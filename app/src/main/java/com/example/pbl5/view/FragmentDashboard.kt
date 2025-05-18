package com.example.pbl5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.pbl5.R
import com.example.pbl5.utils.VibrationUtils
import com.example.pbl5.viewmodel.SpeedViewModel

class FragmentDashboard : Fragment(R.layout.fragment_dashboard) {

    private val viewModelSpeed: SpeedViewModel by viewModels() // observe speed trên firebase


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // observe để xử lý rung cho từng fragment
        viewModelSpeed.speed.observe(viewLifecycleOwner) { speed ->

            when {
                speed in 1..40 -> {
                    VibrationUtils.cancelVibration(requireContext())
                }

                speed in 41..60 -> {
                    VibrationUtils.cancelVibration(requireContext())
                }

                speed > 60 -> {

                    val pattern = longArrayOf(0, 500, 1000) // Rung 500ms, nghỉ 1000ms
                    VibrationUtils.vibrateWithPattern(requireContext(), pattern, 0)
                }

                else -> {
                    // Nếu speed = 0 hoặc không xác định, cũng hủy rung
                    VibrationUtils.cancelVibration(requireContext())

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        VibrationUtils.cancelVibration(requireContext())
    }
}