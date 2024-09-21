package com.example.myselfapp.walthrough

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentThirdWalkthroughBinding
import com.example.myselfapp.MainActivity
import com.example.myselfapp.walthrough.WalkthroughActivity.Companion.FINISH_WALKTHROUGH
import com.example.myselfapp.walthrough.WalkthroughActivity.Companion.dataStore
import kotlinx.coroutines.launch

class ThirdWalkthroughFragment : Fragment() {

    private var _binding: FragmentThirdWalkthroughBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdWalkthroughBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFinish.setOnClickListener {
            lifecycleScope.launch {
                context?.dataStore?.edit { settings ->
                    settings[FINISH_WALKTHROUGH] = true
                }
            }
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnPrevious.setOnClickListener {
            (activity as WalkthroughActivity).setViewPagerItem(1)
        }
    }

}