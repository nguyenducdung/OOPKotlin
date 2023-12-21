package com.example.project2.ui.rooms.data


import com.google.gson.annotations.SerializedName


// Define a data class named "RoomDetailsItemModel" to represent a specific data model structure.
// Properties are defined in the paantheses of "@SerializedName("createdAt")", with a default value of an its data type defined in the final variable.
data class RoomDetailsItemModel(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("isOccupied")
    val isOccupied: Boolean? = false,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int? = 0
)