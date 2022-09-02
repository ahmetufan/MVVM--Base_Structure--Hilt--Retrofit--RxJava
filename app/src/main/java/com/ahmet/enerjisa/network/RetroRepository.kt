package com.ahmet.enerjisa.network

import com.ahmet.enerjisa.model.MenuResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RetroRepository @Inject constructor(private val apiService: ApiService) {

    fun getDataService():Single<MenuResponse>{
        return apiService.getDataAPI()
    }

}