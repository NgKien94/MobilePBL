package com.example.pbl5.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pbl5.model.Speed
import com.example.pbl5.model.Warning
import com.example.pbl5.repository.SpeedRepository
import com.example.pbl5.repository.WarningRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

// Logic
class SpeedViewModel :ViewModel() {
    private val repositorySpeed = SpeedRepository()
    val speed: LiveData<Int> = repositorySpeed.getSpeedLiveData()

    private val repositoryWarning = WarningRepository()
    private val _speedWarnings = MediatorLiveData<List<Warning>>()
    val speedWarnings: LiveData<List<Warning>> = _speedWarnings

    init {
        _speedWarnings.addSource(repositoryWarning.getWarning()) { rawList ->
            val filteredSpeedWarnings = rawList
                .filter { it.type == "speed_warn" } // lọc trước
                .map { warning ->
                    Warning(
                        info = warning.info,
                        timestamp = warning.timestamp,
                        type = warning.getTypeCategory() // nếu cần
                    )
                }
            _speedWarnings.value = filteredSpeedWarnings
        }
    }

}