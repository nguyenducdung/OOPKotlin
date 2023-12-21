package com.example.project2.ui.data

import com.example.project2.ui.data.ApiDetails.ROOMS_ENDPOINT
import com.example.project2.ui.people.data.PeopleInfoItemModel
import com.example.project2.ui.rooms.data.RoomDetailsItemModel
import retrofit2.Response
import retrofit2.http.GET

// Define an interface named "ApiEndpoint" for specifying API endpoints and methods.
interface ApiEndpoint {

    // Define a suspend function to get people information from the API.
    @GET(ApiDetails.PEOPLE_ENDPOINT)
    suspend fun getPeopleInfo(): Response<ArrayList<PeopleInfoItemModel>>

    // Define a suspend function to get room details from the API.
    @GET(ROOMS_ENDPOINT)
    suspend fun getRoomDetails(): Response<ArrayList<RoomDetailsItemModel>>


}
