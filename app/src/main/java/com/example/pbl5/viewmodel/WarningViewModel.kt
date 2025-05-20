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
    private val _spokenWarnings = mutableSetOf<String>()


    init {
        _warnings.addSource(repository.getWarning()) { rawList ->
            val processedList = rawList
                .filter { it.type == "traffic-sign_warn" } // lọc trước
                .map { item ->
                    Warning(
                        info = item.info,
                        timestamp = item.timestamp,
                        type = item.getTypeCategory() // cắt _warn nếu muốn hiển thị gọn
                    )
                }
            _warnings.value = processedList
        }
    }

    fun hasSpoken(warningId: String): Boolean {
        return _spokenWarnings.contains(warningId)
    }

    fun markAsSpoken(warningId: String) {
        _spokenWarnings.add(warningId)
    }


}