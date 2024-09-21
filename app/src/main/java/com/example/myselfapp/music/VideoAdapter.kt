package com.example.myselfapp.music

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemMusicBinding

class VideoAdapter(
    private val musics: Array<Video>
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = musics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = musics[position]
        Glide.with(holder.itemView).load(video.image)
            .into(holder.binding.imgPhoto)

        holder.binding.tvTitle.text = video.director
        holder.binding.tvArtist.text = video.title
    }

    inner class ViewHolder(val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root)
}