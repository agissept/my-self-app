package com.example.myselfapp.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val musics = arrayOf(
            Music("Embrace", "Mika", R.drawable.album),
            Music("Losing Fight", "Mika", R.drawable.album),
            Music("For What It's Worth", "Mika", R.drawable.album),
            Music("Revival", "Mika", R.drawable.album),
            Music("Stay For The Night", "Mika", R.drawable.album),
            Music(
                "For Every Bump On The Road, For Every Storm In The Sky",
                "Mika",
                R.drawable.album
            ),
            Music("Acceptance", "Mika", R.drawable.album),
            Music("Glance", "Mika", R.drawable.album),
        )

        binding.rvMusic.adapter = MusicAdapter(musics)

        val videos = arrayOf(
            Video(
                "The Mandalorian",
                "Jon Favreau",
                ResourcesCompat.getDrawable(resources, R.drawable.the_mandalorian, null)
            ),
            Video(
                "WandaVision",
                "Jac Schaeffer",
                ResourcesCompat.getDrawable(resources, R.drawable.wanda_vision, null)
            ),
            Video(
                "The Believers",
                "Wattanapong Wongwan",
                ResourcesCompat.getDrawable(resources, R.drawable.the_believers, null)
            ),
            Video(
                "Game of Thrones",
                "David Benioff; D. B. Weiss",
                ResourcesCompat.getDrawable(resources, R.drawable.game_of_thrones, null)
            ),
        )

        binding.rvVideo.adapter = VideoAdapter(videos)
    }
}