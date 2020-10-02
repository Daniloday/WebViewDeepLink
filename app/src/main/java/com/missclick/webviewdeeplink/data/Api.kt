package com.missclick.webviewdeeplink.data

import com.missclick.webviewdeeplink.data.models.Users
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("5dcc12d554000064009c20fc")
    suspend fun getUsers(
        @Query("page") page: Int
    ): ResponseWrapper<Users>

    @GET("5dcc147154000059009c2104")
    suspend fun getUsersError(
        @Query("page") page: Int
    ): ResponseWrapper<Users>
}