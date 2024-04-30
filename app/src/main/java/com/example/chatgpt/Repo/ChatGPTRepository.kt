package com.example.chatgpt.Repo

import com.example.chatgpt.API.ChatAPI
import com.example.chatgpt.Database.ChatDatabase
import com.example.chatgpt.Model.ChatGPTResult
import com.example.chatgpt.Model.InputBody
import com.example.chatgpt.Model.Sentiment

class ChatGPTRepository(val chatAPI: ChatAPI) {

   suspend fun getChatResult(body:InputBody,auth:String): ChatGPTResult {

      val data = chatAPI.getChatResult(auth,body)
       return data
    }

    suspend fun getResultFromSentiment(auth: String,body: InputBody):Sentiment{
        val data = chatAPI.getSentimentResult(auth,body)
        return data

    }


}

