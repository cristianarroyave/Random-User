package com.example.cleanarchitecture.provider

import com.example.cleanarchitecture.model.UsersApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface UsersProvider {
    @GET("?results=5&inc=name,picture,email&noinfo")
    suspend fun randomUser(): Response<UsersApiResponse>

}