package com.example.myselfapp.walthrough

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentSecondWalkthroughBinding

class SecondWalkthroughFragment : Fragment() {

    private var _binding: FragmentSecondWalkthroughBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondWalkthroughBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            (activity as WalkthroughActivity).setViewPagerItem(2)
        }
        binding.btnPrevious.setOnClickListener {
            (activity as WalkthroughActivity).setViewPagerItem(0)
        }
    }
}