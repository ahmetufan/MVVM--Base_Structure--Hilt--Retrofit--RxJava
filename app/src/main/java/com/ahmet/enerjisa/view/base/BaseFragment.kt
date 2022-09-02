package com.ahmet.enerjisa.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragment <BindingType : ViewDataBinding, ViewModelType:BaseViewModel> : Fragment() {

    private val baseActivity by lazy { activity as BaseActivity<*, *>? }

     lateinit var binding: BindingType
     protected abstract val viewModel:ViewModelType
     abstract fun getViewBinding():BindingType
     abstract fun onFragmentCreated()
     open fun observe(){}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =getViewBinding()
        onFragmentCreated()
        observe()
        return binding.root
    }




}