package com.example.project2.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.R
import com.example.project2.databinding.RoomInfoBinding
import com.example.project2.ui.rooms.data.RoomDetailsItemModel

// Declare a class named RoomAdapter that extends RecyclerView.Adapter
// The adapter is responsible for managing the data and creating views for the RecyclerView.
class RoomAdapter(private val roomsInfoList: ArrayList<RoomDetailsItemModel>):
    RecyclerView.Adapter<RoomAdapter.RoomsViewHolder>()  {

    // Inner class representing a view holder for each item in the RecyclerView.

    inner class RoomsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Bind the XML layout for each item in the RecyclerView.
        val binding = RoomInfoBinding.bind(view)

        // Set up the UI for a specific item using the provided peopleData and position.
        fun roomDetailsUpdate( roomDetails :RoomDetailsItemModel,position: Int){
            // Set the roomNumber,Max Occupancy and to the corresponding TextView.

            binding.roomNumber.text = roomDetails.id
            binding.maxOccupancied.text = roomDetails.maxOccupancy.toString()
            binding.occupied.text = "${roomDetails.isOccupied}"

        }
    }

    // Override the onCreateViewHolder method to create a RoomsViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RoomsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.room_info,parent,false)
    )

    // Override the getItemCount method to return the total number of items in roomsInfoList.
    override fun getItemCount() = roomsInfoList.size

    // Override the onBindViewHolder method to bind data to a specific RoomsViewHolder.
    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        holder.roomDetailsUpdate(roomsInfoList[position], position)
    }

    // Function to update the room list with new data and notify the adapter of the change.
    fun updateRoomList(roomsDetails: ArrayList<RoomDetailsItemModel>) {
        // Add all the new room details to the existing list.
        roomsInfoList.addAll(roomsDetails)
        // Notify the adapter that the data set has changed.
        notifyDataSetChanged()
    }
}