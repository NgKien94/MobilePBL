package com.example.pbl5.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pbl5.model.Warning
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class WarningRepository {
    private val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("warning")

    fun getWarning() : LiveData<List<Warning>>{
        val warningsLiveData = MutableLiveData<List<Warning>>()
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<Warning>()
                for(child in snapshot.children){
                    val warning = child.getValue(Warning::class.java)
                    warning?.let{list.add(it)}
                }
                warningsLiveData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                warningsLiveData.value = emptyList()// cache
            }
        })
        return warningsLiveData
    }
}