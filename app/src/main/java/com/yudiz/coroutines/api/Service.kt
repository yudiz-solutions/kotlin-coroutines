package com.yudiz.coroutines.api

import com.yudiz.coroutines.model.Model
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("/rest/v2/all")
    fun getCountries(): Deferred<Response<List<Model>>>
}