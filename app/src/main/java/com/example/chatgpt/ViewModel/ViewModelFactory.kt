package com.example.chatgpt.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatgpt.Repo.ChatGPTRepository

class ViewModelFactory(val chatRepo: ChatGPTRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatGPTViewModel(chatRepo) as T
    }

}