package com.example.cleanarchitecture.repository

import com.example.cleanarchitecture.model.Users
import com.example.cleanarchitecture.provider.UsersProvider
import javax.inject.Inject

interface UsersRepository {
    suspend fun getUsers(): List<Users>
}

class UsersRepositoryImp @Inject constructor(
    private val usersProvider: UsersProvider
): UsersRepository {
    private var users: List<Users> = emptyList()

    override suspend fun getUsers(): List<Users> {
        val apiResponse = usersProvider.randomUser().body()
        return apiResponse?.results ?: emptyList()
    }

}