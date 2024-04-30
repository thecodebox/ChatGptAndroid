package com.example.chatgpt.Database

import com.example.chatgpt.API.ChatAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ChatDatabase {


    fun getChatAPI():ChatAPI{

        val actualclass = Retrofit.Builder().baseUrl("https://api-inference.huggingface.co").addConverterFactory(GsonConverterFactory.create()).build().create(ChatAPI::class.java)

        return actualclass

    }

}

