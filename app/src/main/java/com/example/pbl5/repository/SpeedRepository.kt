package com.example.pbl5.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

// Get Data
class SpeedRepository {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("speed")

    fun getSpeedLiveData(): LiveData<Int> {
        val speedLiveData = MutableLiveData<Int>()

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                speedLiveData.value = snapshot.getValue(Int::class.java) ?: 0

            }

            override fun onCancelled(error: DatabaseError) {
                speedLiveData.value = -1
            }
        })

        return speedLiveData
    }
}