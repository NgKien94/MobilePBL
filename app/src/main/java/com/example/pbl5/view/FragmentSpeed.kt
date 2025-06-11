package com.example.pbl5.view

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewTreeObserver
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pbl5.R
import com.example.pbl5.adapter.WarningAdapter
import com.example.pbl5.databinding.FragmentSpeedBinding
import com.example.pbl5.utils.VibrationUtils

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


    private lateinit var warningAdapter: WarningAdapter
    private var lastWarningIds = emptySet<String>()
    private var isVibrating = false



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSpeedBinding.bind(view)



        // Hiển thị tốc độ hiện tại
        viewModel.speed.observe(viewLifecycleOwner) { speed ->
            binding.currentSpeed.text = "$speed\nkm/h"
            when{
               speed in 1 until 40 -> {
                    binding.currentSpeed.setTextColor(Color.parseColor("#4CAF50"))
                   VibrationUtils.cancelVibration(requireContext())
                   isVibrating = false
                }
               speed in 40 .. 59 ->{
                    binding.currentSpeed.setTextColor(Color.parseColor("#FFBF20"))
                   if (isVibrating == false) {
                       val patternCaution = longArrayOf(0, 500, 1000) // Rung 500ms, nghỉ 1000ms
                       VibrationUtils.vibrateWithPattern(requireContext(), patternCaution, 0)
                       isVibrating = true
                   }
                }

                speed >= 60 ->{
                    binding.currentSpeed.setTextColor(Color.parseColor("#E53935"))
                    if (isVibrating == false) {
                        val pattern = longArrayOf(0, 500, 1000) // Rung 500ms, nghỉ 1000ms
                        VibrationUtils.vibrateWithPattern(requireContext(), pattern, 0)
                        isVibrating = true
                    }
                }
                else -> {
                    // Nếu speed = 0 hoặc không xác định, cũng hủy rung
                    VibrationUtils.cancelVibration(requireContext())
                    isVibrating = false
                }
            }
        }

        // Cài đặt recycler view
        warningAdapter = WarningAdapter(emptyList())

        binding.recyclerSpeedWarnings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = warningAdapter
        }

        // Quan sát danh sách warning loại "speed"
        viewModel.speedWarnings.observe(viewLifecycleOwner) { warningList ->
            warningAdapter.updateData(warningList)

            // Xác định cảnh báo mới bằng cách so sánh tập ID
            val currentWarningIds = warningList.map { it.info + it.timestamp }.toSet()
            lastWarningIds = currentWarningIds

            val itemCount = warningAdapter.itemCount
            if (itemCount > 0) {
                binding.recyclerSpeedWarnings.smoothScrollToPosition(itemCount - 1)

                // Cuộn scroll sau khi render (nếu cần)
                binding.recyclerSpeedWarnings.post {
                    binding.root.fullScroll(View.FOCUS_DOWN)
                }
            } else {
                // Nếu không có dữ liệu, có thể hiển thị text rỗng hoặc ẩn recyclerView tùy UX/UI
                Log.d("FragmentSpeed", "No speed warnings to display.")
            }

        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        VibrationUtils.cancelVibration(requireContext())
        isVibrating = false
        _binding = null // destroy binding
    }
}