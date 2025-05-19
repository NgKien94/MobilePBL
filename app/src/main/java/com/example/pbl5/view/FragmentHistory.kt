package com.example.pbl5.view

import android.graphics.Color
import android.media.MediaPlayer
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
    private val categories = arrayOf(
        "Cấm đi ngược chiều", "Cấm xe ô tô", "Tốc độ tối đa cho phép",
        "Cấm rẽ trái", "Cấm rẽ phải"
    )
    private val warningSoundMap = mapOf(
        "Cấm đi ngược chiều" to R.raw.traffic_p102,
        "Cấm xe ô tô" to R.raw.traffic_p103a,
        "Tốc độ tối đa cho phép" to R.raw.traffic_p127,
        "Cấm rẽ trái" to R.raw.traffic_p123a,
        "Cấm rẽ phải" to R.raw.traffic_p123b
    )

    private val selectedCategories = mutableSetOf<String>()  // các mục đã chọn


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)

        // xử lý phát âm
        binding.btnSelectCategories.setOnClickListener {
            val checkedItems = BooleanArray(categories.size) { i -> selectedCategories.contains(categories[i]) }

            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Chọn loại biển báo quan trọng cần phát âm thanh")
                .setMultiChoiceItems(categories, checkedItems) { _, which, isChecked ->
                    if (isChecked) {
                        selectedCategories.add(categories[which])
                    } else {
                        selectedCategories.remove(categories[which])
                    }
                }
                .setPositiveButton("OK") { dialog, _ ->
                    binding.tvSelectedCategories.text = "Đã chọn: ${selectedCategories.joinToString(", ")}"
                    dialog.dismiss()
                }
                .show()
        }


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

            warningAdapter.updateData(warningList)
            binding.recyclerWarnings.scrollToPosition(warningAdapter.itemCount - 1)

            // xử lý phát âm thanh
            if (warningList.isNotEmpty()) {
                val latestWarning = warningList.last()
                val infoParts = latestWarning.info.split("-").map { it.trim() }
                if (infoParts.size >= 2) {
                    val label = infoParts[1]  // "Tốc độ tối đa cho phép"
                    if (selectedCategories.contains(label)) {
                        playWarningSound(label)
                    }
                }
            }

        }
    }

    private fun playWarningSound(label: String) {
        val soundResId = warningSoundMap[label] ?: return
        val mediaPlayer = MediaPlayer.create(requireContext(), soundResId)
        mediaPlayer.setOnCompletionListener {
            it.release()
        }
        mediaPlayer.start()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        VibrationUtils.cancelVibration(requireContext())
        _binding = null
    }

}