package com.ahmet.enerjisa.network

import com.ahmet.enerjisa.model.MenuResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("main/menu.json")
    fun getDataAPI(): Single<MenuResponse>

}