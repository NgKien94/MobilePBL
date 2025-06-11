package com.example.pbl5.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.pbl5.R
import com.example.pbl5.databinding.FragmentDashboardBinding
import com.example.pbl5.model.Warning

import com.example.pbl5.utils.VibrationUtils
import com.example.pbl5.viewmodel.DashboardViewModel
import com.example.pbl5.viewmodel.SpeedViewModel

class FragmentDashboard : Fragment(R.layout.fragment_dashboard) {

    private var _binding : FragmentDashboardBinding? =  null
    private val binding get() = _binding!!  // Đảm bảo binding không null
    private val viewModelSpeed: SpeedViewModel by viewModels() // observe speed trên firebase
    private val dashboardViewModel: DashboardViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)


        // observe để xử lý rung cho từng fragment
        viewModelSpeed.speed.observe(viewLifecycleOwner) { speed ->


            // Cập nhật tốc độ hiện tại
            binding.tvCurrentSpeed.text = "$speed km/h"

            // Cập nhật trạng thái lái xe
            val statusLayout = binding.layoutStatus
            val statusText = binding.tvStatusValue

            when {
                speed in 1 until 40 -> {
                    statusText.text = "Safe Driving"
                    statusText.setTextColor(Color.parseColor("#34C759")) // green
                    statusLayout.setBackgroundColor(Color.parseColor("#DFFFE0"))

                    VibrationUtils.cancelVibration(requireContext())
                }

                speed in 40..59 -> {
                    statusText.text = "Caution"
                    statusText.setTextColor(Color.parseColor("#FF9500")) // orange
                    statusLayout.setBackgroundColor(Color.parseColor("#FFF3CD"))
                    val patternCaution = longArrayOf(0, 500, 1000) // Rung 500ms, nghỉ 1000ms
                    VibrationUtils.vibrateWithPattern(requireContext(), patternCaution, 0)
                }

                speed >= 60 -> {
                    statusText.text = "Danger"
                    statusText.setTextColor(Color.parseColor("#FF3B30")) // red
                    statusLayout.setBackgroundColor(Color.parseColor("#F8D7DA"))
                    val pattern = longArrayOf(0, 500, 1000) // Rung 500ms, nghỉ 1000ms
                    VibrationUtils.vibrateWithPattern(requireContext(), pattern, 0)
                }

                else -> {
                    statusText.text = "Unknown"
                    statusText.setTextColor(Color.GRAY)
                    statusLayout.setBackgroundColor(Color.LTGRAY)
                    // Nếu speed = 0 hoặc không xác định, cũng hủy rung
                    VibrationUtils.cancelVibration(requireContext())

                }
            }
        }

        // xử lý cho dashboard
        dashboardViewModel.latestSpeedWarning.observe(viewLifecycleOwner) { warning ->
            binding.layoutSpeedWarning.removeAllViews()
            if (warning != null) {
                binding.layoutSpeedWarning.addView(createWarningView(warning))
            } else {
                binding.layoutSpeedWarning.addView(createFallbackView("No speed warning"))
            }
        }

        dashboardViewModel.latestTrafficWarnings.observe(viewLifecycleOwner) { warnings ->
            binding.layoutTrafficWarnings.removeAllViews()
            if (warnings.isNotEmpty()) {
                warnings.forEach {
                    binding.layoutTrafficWarnings.addView(createWarningView(it))
                }
            } else {
                binding.layoutTrafficWarnings.addView(createFallbackView("No traffic sign warnings"))
            }
        }


    }
    private fun createWarningView(warning: Warning): View {
        val itemView = LayoutInflater.from(requireContext())
            .inflate(R.layout.item_warning_dashboard, null, false)

        val imWarningIcon = itemView.findViewById<ImageView>(R.id.im_warningIcon)
        val tvType = itemView.findViewById<TextView>(R.id.tv_type)
        val tvInfo = itemView.findViewById<TextView>(R.id.tv_info)
        val tvTimestamp = itemView.findViewById<TextView>(R.id.tv_timestamp)
        val stripeView = itemView.findViewById<View>(R.id.view_warningStripe)

        // Gán nội dung và màu sắc tùy theo type
        when (warning.type) {
            "speed" -> {
                imWarningIcon.setImageResource(R.drawable.warning_speed)
                tvType.text = "Speed Limit Exceeded"
                stripeView.setBackgroundColor(Color.parseColor("#FF3B30")) // Red
            }
            "traffic-sign" -> {
                imWarningIcon.setImageResource(R.drawable.warning_traffic_sign)
                tvType.text = "Traffic Sign Detected"
                stripeView.setBackgroundColor(Color.parseColor("#FF9500")) // Orange
            }
            else -> {
                imWarningIcon.setImageResource(R.drawable.fallback_icon)
                tvType.text = "Unknown Warning"
                stripeView.setBackgroundColor(Color.LTGRAY)
            }
        }

        tvInfo.text = warning.info
        tvTimestamp.text = warning.timestamp

        return itemView
    }


    private fun createFallbackView(message: String): View {
        val textView = TextView(requireContext())
        textView.text = message
        textView.setTextColor(Color.GRAY)
        textView.textSize = 14f
        textView.setPadding(16, 16, 16, 16)
        return textView
    }




    override fun onDestroyView() {
        super.onDestroyView()
        VibrationUtils.cancelVibration(requireContext())
        _binding = null // destroy binding
    }
}