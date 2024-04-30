package com.example.chatgpt.View.Adapaters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatgpt.Model.ChatModel
import com.example.chatgpt.View.ViewHolder.ChatGptViewHolder
import com.example.chatgpt.View.ViewHolder.UserChatViewHolder
import com.example.chatgpt.databinding.ChatGptCellBinding
import com.example.chatgpt.databinding.UserChatCellBinding

class ChatGPTAdapter(val data:ArrayList<ChatModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if(data[position].isUser)
        {
            return 0
        }else{
            return 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        if(viewType == 0)
        {
            return UserChatViewHolder(UserChatCellBinding.inflate(layoutInflater,parent,false))
        }else{

            return ChatGptViewHolder(ChatGptCellBinding.inflate(layoutInflater,parent,false))


        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is ChatGptViewHolder){
            val mybinding = holder as ChatGptViewHolder
            mybinding.binding.textView1.text = data[position].message

        }else{
            val mybinding = holder as UserChatViewHolder
            mybinding.binding.textView2.text = data[position].message

        }


    }
}