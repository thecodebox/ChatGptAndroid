package com.example.chatgpt.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatgpt.Model.ChatGPTResult
import com.example.chatgpt.Model.ChatModel
import com.example.chatgpt.Model.InputBody
import com.example.chatgpt.Repo.ChatGPTRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ChatGPTViewModel(val chatRepo:ChatGPTRepository):ViewModel() {

//    val data = MutableLiveData<ChatGPTResult>(ChatGPTResult())

    val recylerViewData = MutableLiveData<ArrayList<ChatModel>>(ArrayList())


    fun getChatGPTResult(body:InputBody,auth:String){

        val tempdata =  recylerViewData.value
        tempdata?.add(ChatModel(body.inputs,true))
        if(tempdata != null){

            recylerViewData.postValue(tempdata)
        }


        viewModelScope.launch {

         val data = async(Dispatchers.IO) {
                chatRepo.getChatResult(body,auth)

            }

          val finaldata = data.await()

            tempdata?.add(ChatModel(finaldata[0].generated_text,false))

            if(tempdata != null){
                recylerViewData.postValue(tempdata)
            }


        }



    }





}
