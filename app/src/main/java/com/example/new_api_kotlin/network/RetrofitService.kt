package com.example.new_api_kotlin.network

import com.example.example.Data
import com.example.example.ExampleJson2KtKotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {
//   @Headers("Accept:application/json","Content-Type: application/json")
    @GET("users?page=2")
    fun getData():Call<ExampleJson2KtKotlin>
}