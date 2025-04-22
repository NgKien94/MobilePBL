package com.example.pbl5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pbl5.R
import com.example.pbl5.adapter.WarningAdapter
import com.example.pbl5.databinding.FragmentHistoryBinding
import com.example.pbl5.databinding.FragmentSpeedBinding
import com.example.pbl5.viewmodel.SpeedViewModel
import com.example.pbl5.viewmodel.WarningViewModel


class FragmentHistory : Fragment(R.layout.fragment_history) {

    private var _binding : FragmentHistoryBinding ? =  null
    private val binding get() = _binding!!  // Đảm bảo binding không null
    private val viewModel: WarningViewModel by viewModels()
    private lateinit var warningAdapter: WarningAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)

        warningAdapter = WarningAdapter(emptyList())
        binding.recyclerWarnings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = warningAdapter
        }


        viewModel.warnings.observe(viewLifecycleOwner) {warningList ->
            warningAdapter.updateData(warningList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}