package com.example.myselfapp.dailyactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDailyActivityBinding

class DailyActivityFragment : Fragment() {
    private var _binding: FragmentDailyActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friends =
            arrayOf(
                mapOf("name" to "John", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_1, null)),
                mapOf("name" to "Doe", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_3, null)),
                mapOf("name" to "Foo", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_4, null)),
                mapOf("name" to "Bar", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_5, null)),
                mapOf("name" to "Baz", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_6, null)),
                mapOf("name" to "Qux", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_7, null)),
                mapOf("name" to "Quux", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_8, null)),
                mapOf("name" to "Corge", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_9, null)),
                mapOf("name" to "Grault", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_10, null)),
                mapOf("name" to "Jane", "image" to ResourcesCompat.getDrawable(resources, R.drawable.gallery_2, null)),
            )

        val friendAdapter = FriendAdapter(friends as Array<Map<String, Any>>)
        binding.rvFriends.adapter = friendAdapter


        val activities =
            arrayOf(
                mapOf("name" to "Wake Up", "image" to R.drawable.baseline_wb_sunny_24),
                mapOf("name" to "Prepare to Work", "image" to R.drawable.baseline_checklist_24),
                mapOf("name" to "Work", "image" to R.drawable.baseline_work_24),
                mapOf("name" to "Break", "image" to R.drawable.baseline_fastfood_24),
                mapOf("name" to "Work", "image" to R.drawable.baseline_work_24),
                mapOf("name" to "Back Home", "image" to R.drawable.baseline_home_24),
                mapOf("name" to "Study", "image" to R.drawable.baseline_school_24),
                mapOf("name" to "Watch Movie", "image" to R.drawable.baseline_movie_24),
                mapOf("name" to "Prepare to Sleep", "image" to R.drawable.baseline_bedtime_24),
                mapOf("name" to "Sleep", "image" to R.drawable.baseline_nights_stay_24),
            )

        val activityAdapter = ActivityAdapter(activities as Array<Map<String, Any>>)
        binding.rvActivities.adapter = activityAdapter
    }
}