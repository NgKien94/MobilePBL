package com.example.pbl5.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pbl5.model.Speed
import com.example.pbl5.repository.SpeedRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

// Logic
class SpeedViewModel :ViewModel() {
    private val repositorySpeed = SpeedRepository()
    val speed: LiveData<Int> = repositorySpeed.getSpeedLiveData()

}