package com.example.livecodekotlinandroid.bank

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.livecodekotlinandroid.config.RetrofitBuilder

class BankViewModel : ViewModel(){
    val bankRepository: BankRepository

    init {
        val bankAPI = RetrofitBuilder.createRetrofit().create(BankAPI::class.java)
        bankRepository = BankRepository(bankAPI)
    }

    val transaction: LiveData<Bank> = bankRepository.transaction
    val allTransaction: LiveData<List<Bank>> = bankRepository.allTransaction

    fun getAllTransaction(){
        bankRepository.getAllTransaction()
    }

    fun saveTransaction(bank: Bank) {
        bankRepository.saveTransaction(bank)
    }

}