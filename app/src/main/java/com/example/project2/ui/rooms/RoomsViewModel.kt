package com.example.project2.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project2.ui.data.ApiDetails
import com.example.project2.ui.rooms.data.RoomDetails
import com.example.project2.ui.rooms.data.RoomDetailsItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomsViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    private val _roomDetails = MutableLiveData<ArrayList<RoomDetailsItemModel>>()
    val roomDetails: LiveData<ArrayList<RoomDetailsItemModel>> = _roomDetails


    fun getDetails() {
        GlobalScope.launch {
            val result = ApiDetails.service.getRoomDetails()
            if (result.isSuccessful) {
                _roomDetails.postValue(result.body())
            } else {
                _roomDetails.postValue(RoomDetails())
            }}
    }


}