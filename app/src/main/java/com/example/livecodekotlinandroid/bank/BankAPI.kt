package com.example.livecodekotlinandroid.bank

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface BankAPI {
    @GET("transactions")
    fun getAllTransaction(): Call<List<Bank>>

    @POST("transactions")
    fun createTransaction(@Body bank: Bank): Call<Bank>

}