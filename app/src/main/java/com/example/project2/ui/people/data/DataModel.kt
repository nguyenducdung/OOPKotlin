package com.example.project2.ui.people.data


import com.google.gson.annotations.SerializedName


// Define a data class named "DataModel" to represent a specific data model structure.
data class DataModel(
    // Define a property named "body" with a default value of an empty string.
    @SerializedName("body")
    val body: String? = "",

    // Define a property named "fromId" with a default value of an empty string.
    @SerializedName("fromId")
    val fromId: String? = "",

    // Define a property named "id" with a default value of an empty string.
    @SerializedName("id")
    val id: String? = "",

    // Define a property named "meetingid" with a default value of an empty string.
    @SerializedName("meetingid")
    val meetingid: String? = "",

    // Define a property named "title" with a default value of an empty string.
    @SerializedName("title")
    val title: String? = "",

    // Define a property named "toId" with a default value of an empty string.
    @SerializedName("toId")
    val toId: String? = ""
)