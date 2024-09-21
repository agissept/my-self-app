package com.example.myselfapp.dailyactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemFriendBinding

class FriendAdapter(
    private val friends: Array<Map<String, Any>>
) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = friends.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = friends[position]
        Glide.with(holder.itemView).load(friend["image"])
            .into(holder.binding.imgPhoto)
        holder.binding.tvName.text = friend["name"].toString()
    }

    inner class ViewHolder(val binding: ItemFriendBinding) : RecyclerView.ViewHolder(binding.root)
}