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

    init {
        _warnings.addSource(repository.getWarning()) { rawList ->
            val processedList = rawList
                .filter { it.type != "speed_warn" } // lọc bỏ speed
                .map { item ->
                    Warning(
                        info = item.info,
                        timestamp = item.timestamp,
                        type = item.getTypeCategory() // cắt hậu tố "_warn"
                    )
                }
            _warnings.value = processedList
        }
    }

}