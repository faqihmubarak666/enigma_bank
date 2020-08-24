package com.example.livecodekotlinandroid.bank

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BankRepository (val bankAPI: BankAPI){

    var transaction: MutableLiveData<Bank> = MutableLiveData<Bank>()
    var allTransaction : MutableLiveData<List<Bank>> = MutableLiveData<List<Bank>>()

    fun getAllTransaction(){
        bankAPI.getAllTransaction().enqueue(object : Callback<List<Bank>> {
            override fun onFailure(call: Call<List<Bank>>, t: Throwable) {
                println("Failed Because ${t.localizedMessage}")
                println("${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<List<Bank>>, response: Response<List<Bank>>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                val transactionObject:List<Bank> = gson.fromJson(stringResponse,Array<Bank>::class.java).toList()
                allTransaction.value = transactionObject
            }
        })
    }

    fun saveTransaction(bank: Bank) {
        bankAPI.createTransaction(bank).enqueue(object : Callback<Bank> {
            override fun onResponse(call: Call<Bank>, response: Response<Bank>) {
                if (response.code() == 200) {
                    println("SUCCESS")
                }
            }

            override fun onFailure(call: Call<Bank>, t: Throwable) {
                t.printStackTrace()
                println("Failed Created Film Because  ${t.localizedMessage}")
            }

        })
    }

}