package com.example.pbl5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.pbl5.model.Warning
import com.example.pbl5.repository.WarningRepository

class WarningViewModel : ViewModel(){
    private val repository = WarningRepository()
    private val _warnings = MediatorLiveData<List<Warning>>()
    val warnings: LiveData<List<Warning>> = _warnings

    // MediatorLiveData giúp quan sát nhiều nguồn LiveData khác nhau
    // addSource giống như observe, xử lý dữ liệu cho list rồi cập nhật list mới

    init {
        // Gộp dữ liệu từ repository và xử lý
        _warnings.addSource(repository.getWarning()) { rawList ->
            val processedList = rawList.map { item ->
                Warning(
                    info = item.info,
                    timestamp = item.timestamp,
                    type = item.getTypeCategory()
                )
            }
            _warnings.value = processedList
        }
    }

}