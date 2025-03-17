package com.example.pbl5.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pbl5.model.Speed
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SpeedViewModel :ViewModel() {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("speed")
    private val _speed = MutableLiveData<Int>() // dữ liệu speed
    val speed: LiveData<Int> get() = _speed  // Để Fragment có thể quan sát

    init{
        fetchSpeed()
    }

    private fun fetchSpeed(){
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                _speed.value = snapshot.getValue(Int::class.java) ?:0
            }

            override fun onCancelled(error: DatabaseError) {
                _speed.value = -1 // Đánh dấu lỗi nếu không đọc được dữ liệu
                Log.d("SPEED","In ViewModel : Error read speed in firebase")
            }
        })
    }
}