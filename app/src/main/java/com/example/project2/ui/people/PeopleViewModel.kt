package com.example.project2.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.ui.data.ApiDetails
import com.example.project2.ui.people.data.PeopleInfo
import com.example.project2.ui.people.data.PeopleInfoItemModel
import com.example.project2.ui.rooms.data.RoomDetails
import com.example.project2.ui.rooms.data.RoomDetailsItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Define a class named "PeopleViewModel" that extends ViewModel.
class PeopleViewModel : ViewModel() {

    // MutableLiveData to hold the counter value.
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    // MutableLiveData to hold the person details.
    private val _personDetails = MutableLiveData<ArrayList<PeopleInfoItemModel>>()
    val personDetails: LiveData<ArrayList<PeopleInfoItemModel>> = _personDetails

    // Function to fetch person details using a coroutine.
    fun getPersonDetails() {
        GlobalScope.launch {

            // Make an API request to get people information.

            val result = ApiDetails.retrofitApi.getPeopleInfo()

            // Update the _personDetails LiveData based on the API response.
            if (result.isSuccessful) {
                _personDetails.postValue(result.body())
            } else {
                _personDetails.postValue(PeopleInfo())
            }
        }
    }
}
