package com.example.myselfapp.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = arrayOf(
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_1, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_2, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_3, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_4, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_5, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_6, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_7, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_8, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_9, null),
            ResourcesCompat.getDrawable(resources, R.drawable.gallery_10, null),
        )

        val adapter = GalleryAdapter(images)
        binding.recyclerView.adapter = adapter
    }

}