package com.e.fakeapi

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value ="products")
    suspend fun getProduct(): Response<List<Products>>
}