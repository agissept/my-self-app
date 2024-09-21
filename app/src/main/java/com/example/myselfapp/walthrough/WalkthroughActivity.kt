package com.example.myselfapp.walthrough

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityWalkthroughBinding
import com.example.myselfapp.MainActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class WalkthroughActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWalkthroughBinding
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        runBlocking {
            val dataStore = applicationContext.dataStore
            val finishWalkthrough = dataStore.data.first()[FINISH_WALKTHROUGH] ?: 0
            if (finishWalkthrough == true) {
                val intent = Intent(this@WalkthroughActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding = ActivityWalkthroughBinding.inflate(layoutInflater)
        setContentView(binding.root)

        println("init viewpager")

        val sectionsPagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> FirstWalkthroughFragment()
            1 -> SecondWalkthroughFragment()
            2 -> ThirdWalkthroughFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }

    companion object {
        val FINISH_WALKTHROUGH = booleanPreferencesKey("finishWalkthrough")
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    }

    fun setViewPagerItem(position: Int) {
        viewPager.currentItem = position
    }
}