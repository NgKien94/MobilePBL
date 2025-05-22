package com.example.pbl5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.pbl5.model.Warning
import com.example.pbl5.repository.WarningRepository

class DashboardViewModel : ViewModel() {
    private val repository = WarningRepository()
    private val _latestSpeedWarning = MediatorLiveData<Warning?>()
    val latestSpeedWarning: LiveData<Warning?> = _latestSpeedWarning

    private val _latestTrafficWarnings = MediatorLiveData<List<Warning>>()
    val latestTrafficWarnings: LiveData<List<Warning>> = _latestTrafficWarnings

    init {
        _latestSpeedWarning.addSource(repository.getWarning()) { rawList ->
            _latestSpeedWarning.value = rawList
                .filter { it.type == "speed_warn" }
                .maxByOrNull { it.getTimestampAsDate()?.time ?: 0L}
                ?.let {
                    Warning(it.info, it.timestamp, it.getTypeCategory())
                }
        }

        _latestTrafficWarnings.addSource(repository.getWarning()) { rawList ->
            _latestTrafficWarnings.value = rawList
                .filter { it.type == "traffic-sign_warn" }
                .sortedByDescending { it.getTimestampAsDate()?.time ?: 0L }
                .take(3)
                .map {
                    Warning(it.info, it.timestamp, it.getTypeCategory())
                }
        }
    }
}