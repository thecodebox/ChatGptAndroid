package com.example.chatgpt.API

import com.example.chatgpt.Model.ChatGPTResult
import com.example.chatgpt.Model.InputBody
import com.example.chatgpt.Model.Sentiment
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatAPI {

    @POST("/models/google/gemma-1.1-7b-it")
     suspend fun getChatResult(
        @Header("Authorization") auth:String,
        @Body body:InputBody
    ):ChatGPTResult

    @POST("/models/cardiffnlp/twitter-roberta-base-sentiment-latest")
    suspend fun getSentimentResult(
        @Header("Authorization") auth:String,
        @Body body:InputBody
    ): Sentiment


}