package com.example.myselfapp.profile

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentProfileBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.btnInstagram.setOnClickListener {
            val url = "https://www.instagram.com/agissept"
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        binding.btnEmail.setOnClickListener {
            val email = "agis.septiyanto@mail.com"
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            startActivity(intent)
        }

        binding.btnPhone.setOnClickListener {
            val phoneNumber = "08953552465511"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        binding.btnAbout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("About")
                .setMessage("Version 1.0.0")
                .show()
        }

        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync {
            val myAddress = LatLng(-6.895693492639851, 107.6339307441803)
            it.addMarker(MarkerOptions().position(myAddress).title("Office Address"))
            it.moveCamera(CameraUpdateFactory.newLatLng(myAddress))
            it.animateCamera(CameraUpdateFactory.newLatLngZoom(myAddress, 16f))
        }

        val mainScrollView = binding.root
        val transparentImageView = binding.ivTransparent

        transparentImageView.setOnTouchListener { _, event ->
            val action = event.action
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    // Disallow ScrollView to intercept touch events.
                    mainScrollView.requestDisallowInterceptTouchEvent(true)
                    // Disable touch on transparent view
                    false
                }

                MotionEvent.ACTION_UP -> {
                    // Allow ScrollView to intercept touch events.
                    mainScrollView.requestDisallowInterceptTouchEvent(false)
                    true
                }

                MotionEvent.ACTION_MOVE -> {
                    mainScrollView.requestDisallowInterceptTouchEvent(true)
                    false
                }

                else -> true
            }
        }


    }

}