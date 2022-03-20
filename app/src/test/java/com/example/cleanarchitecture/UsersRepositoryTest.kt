package com.example.cleanarchitecture

import com.example.cleanarchitecture.provider.UsersProvider
import com.example.cleanarchitecture.repository.UsersRepositoryImp
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

class ExampleUnitTest {
    private val mockWebServer = MockWebServer()

    private val usersProvider = Retrofit.Builder().baseUrl(mockWebServer.url("/")).client(
        OkHttpClient.Builder().build()).addConverterFactory(GsonConverterFactory.create()).build().create(UsersProvider::class.java)

    private val usersRepository = UsersRepositoryImp(usersProvider)

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun `Random User is correct`(){
        mockWebServer.enqueueResponse("users.json")
        runBlocking{
            val users = usersRepository.getUsers()
            assertEquals(5, users.size)
            assertEquals("Jenny", users[0].name.first)
        }

    }
}

fun MockWebServer.enqueueResponse(filePath: String){
    val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
    val source = inputStream?.source()?.buffer()
    source?.let {
        enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(it.readString(StandardCharsets.UTF_8))
        )
    }
}