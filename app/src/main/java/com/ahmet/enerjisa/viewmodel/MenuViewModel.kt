package com.ahmet.enerjisa.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ahmet.enerjisa.model.MenuResponse
import com.ahmet.enerjisa.network.RetroRepository
import com.ahmet.enerjisa.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(myApp:Application,private val repository: RetroRepository) : BaseViewModel(myApp) {

    private val compositDisposable = CompositeDisposable()

    val liveDataList = MutableLiveData<MenuResponse>()
    val dataLoading = MutableLiveData<Boolean>()
    val dataError=MutableLiveData<Boolean>()

    fun refreshData() {
        getDataFromAPI()
    }

    private fun getDataFromAPI() {

        dataLoading.value = true
        dataError.value=false

        compositDisposable.add(
            repository.getDataService()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MenuResponse>() {
                    override fun onSuccess(t: MenuResponse) {
                        liveDataList.value = t
                        dataLoading.value = false
                        dataError.value=false
                    }

                    override fun onError(e: Throwable) {
                        dataLoading.value = false
                        dataError.value=true
                        e.printStackTrace()
                    }

                })
        )
    }

}