package com.example.pbl5.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels

import androidx.lifecycle.ViewModelStore
import com.example.pbl5.R
import com.example.pbl5.databinding.FragmentSpeedBinding
import com.example.pbl5.viewmodel.SpeedViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentSpeed : Fragment(R.layout.fragment_speed) {


    private var _binding: FragmentSpeedBinding? = null
    private val binding get() = _binding!!  // Đảm bảo binding không null
    private val viewModel: SpeedViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSpeedBinding.bind(view)

        viewModel.speed.observe(viewLifecycleOwner) { speed ->
            binding.currentSpeed.text = "$speed\nkm/h"
            when{
               speed in 1.. 40 -> {
                    binding.currentSpeed.setTextColor(Color.parseColor("#4CAF50"))
                }
               speed in 41..60 ->{
                    binding.currentSpeed.setTextColor(Color.parseColor("#FFBF20"))
                }

                speed > 60 ->{
                    binding.currentSpeed.setTextColor(Color.parseColor("#E53935"))
                }
            }
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // destroy binding
    }
}