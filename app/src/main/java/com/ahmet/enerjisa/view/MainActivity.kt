package com.ahmet.enerjisa.view

import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ahmet.enerjisa.R
import com.ahmet.enerjisa.databinding.ActivityMainBinding
import com.ahmet.enerjisa.view.base.BaseActivity
import com.ahmet.enerjisa.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override val viewModel:MainActivityViewModel by viewModels()


    private lateinit var navController: NavController

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)


    override fun onActivityCreated() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment)
        navController = (navHostFragment as NavHostFragment).navController

    }

    override fun observe() {}



}