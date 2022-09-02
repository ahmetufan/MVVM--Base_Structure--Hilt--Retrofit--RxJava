package com.ahmet.enerjisa.viewmodel

import android.app.Application
import com.ahmet.enerjisa.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(myApp:Application) : BaseViewModel(myApp)  {
}