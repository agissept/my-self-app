package com.example.myselfapp.dailyactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemActivityBinding

class ActivityAdapter(
    private val activities: Array<Map<String, Any>>
) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = activities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]
        Glide.with(holder.itemView).load(activity["image"])
            .into(holder.binding.imgActivity)
        holder.binding.tvActivityName.text = activity["name"].toString()
    }

    inner class ViewHolder(val binding: ItemActivityBinding) : RecyclerView.ViewHolder(binding.root)
}