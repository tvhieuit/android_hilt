package com.study.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("get")
    fun testGet(@Query("id") id: String) : Observable<Any>
}