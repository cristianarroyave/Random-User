package com.example.cleanarchitecture.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("picture")
    val picture: Picture
)