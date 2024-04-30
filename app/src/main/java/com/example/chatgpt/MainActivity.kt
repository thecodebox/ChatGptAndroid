package com.example.chatgpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatgpt.Database.ChatDatabase
import com.example.chatgpt.Model.ChatModel
import com.example.chatgpt.Model.InputBody
import com.example.chatgpt.Repo.ChatGPTRepository
import com.example.chatgpt.View.Adapaters.ChatGPTAdapter
import com.example.chatgpt.ViewModel.ChatGPTViewModel
import com.example.chatgpt.ViewModel.ViewModelFactory
import com.example.chatgpt.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var chatViewModel:ChatGPTViewModel
    lateinit var ChatViewModelFactory:ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ChatViewModelFactory = ViewModelFactory(ChatGPTRepository(ChatDatabase.getChatAPI()))


        chatViewModel = ViewModelProvider(this,ChatViewModelFactory).get(ChatGPTViewModel::class.java)

        binding.button.setOnClickListener({

            chatViewModel.getChatGPTResult(InputBody(binding.editTextText.text.toString()),"Bearer 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")


        })

        val data = arrayListOf<ChatModel>()
        val adapter = ChatGPTAdapter(data)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        chatViewModel.recylerViewData.observe(this,{
           adapter.data.clear()
           adapter.data.addAll(it)
            adapter.notifyItemInserted(data.size - 1)
            binding.rv.scrollToPosition(data.size - 1)
        })






    }
}