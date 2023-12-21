package com.example.project2.ui.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Define an object named "ApiDetails" to hold API-related details and configurations.
object ApiDetails {

    // Define the base URL for the API.
    //https:// 61e947967bc0550017bc61bf.mockapi.io/api/v1/
    val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"

    // Define constants for the API endpoints.
    const val PEOPLE_ENDPOINT = "people"
    const val ROOMS_ENDPOINT = "rooms"

    // Set up Retrofit to build API requests.
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().
        addInterceptor(HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create a service to send API requests using Retrofit.w
    val service = retrofit.create(ApiEndpoint::class.java)

    val retrofitApi: ApiEndpoint
        get() {
            return if (service != null) {
                service
            } else {
                create()
            }
        }

    private fun create(): ApiEndpoint {
        return retrofit.create(ApiEndpoint::class.java)
    }

}