package com.example.pbl5.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pbl5.R
import com.example.pbl5.adapter.WarningAdapter
import com.example.pbl5.databinding.FragmentHistoryBinding
import com.example.pbl5.databinding.FragmentSpeedBinding
import com.example.pbl5.utils.VibrationUtils
import com.example.pbl5.viewmodel.SpeedViewModel
import com.example.pbl5.viewmodel.WarningViewModel


class FragmentHistory : Fragment(R.layout.fragment_history) {

    private var _binding : FragmentHistoryBinding ? =  null
    private val binding get() = _binding!!  // Đảm bảo binding không null
    private val viewModel: WarningViewModel by viewModels()
    private val viewModelSpeed: SpeedViewModel by viewModels() // observe speed trên firebase


    private lateinit var warningAdapter: WarningAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)

        //   observe để xử lý rung cho từng fragment
        viewModelSpeed.speed.observe(viewLifecycleOwner) { speed ->

            when{
                speed in 1.. 40 -> {
                    VibrationUtils.cancelVibration(requireContext())
                }
                speed in 41..60 ->{
                    VibrationUtils.cancelVibration(requireContext())
                }

                speed > 60 ->{

                        val pattern = longArrayOf(0, 500, 1000) // Rung 500ms, nghỉ 1000ms
                        VibrationUtils.vibrateWithPattern(requireContext(), pattern, 0)
                }
                else -> {
                    // Nếu speed = 0 hoặc không xác định, cũng hủy rung
                    VibrationUtils.cancelVibration(requireContext())

                }
            }
        }


        warningAdapter = WarningAdapter(emptyList())
        binding.recyclerWarnings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = warningAdapter
        }


        viewModel.warnings.observe(viewLifecycleOwner) {warningList ->
            warningAdapter.updateData(warningList)
            binding.recyclerWarnings.scrollToPosition(warningAdapter.getItemCount() - 1)
            // cuộn về item cuối danh sách mỗi khi có item mới
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        VibrationUtils.cancelVibration(requireContext())
        _binding = null
    }

}