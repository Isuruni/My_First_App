package com.uni.kelani.myfirstapp.api

import com.uni.kelani.myfirstapp.models.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPIService{
    @GET("users")
    fun getUsers(): Call<List<Users>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") id:String) : Call <Users>

    companion object{
        val API_URL= "https://jsonplaceholder.typicode.com"
        fun create(): UserAPIService {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(UserAPIService::class.java)
        }
    }
}

