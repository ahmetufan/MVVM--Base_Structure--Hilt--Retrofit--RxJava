package com.ahmet.enerjisa.view

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.ahmet.enerjisa.databinding.FragmentMenuBinding
import com.ahmet.enerjisa.view.base.BaseFragment
import com.ahmet.enerjisa.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding,MenuViewModel>() {

    override val viewModel: MenuViewModel by viewModels()

    override fun getViewBinding()=FragmentMenuBinding.inflate(layoutInflater)

    override fun onFragmentCreated() {}


    override fun observe() {

        viewModel.refreshData()

        swipeRefresh()

        initViewModel()


        binding.abonelikText.setOnClickListener {
            val action=MenuFragmentDirections.actionMenuFragmentToFormFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    private fun initViewModel() {

        viewModel.liveDataList.observe(viewLifecycleOwner, Observer { livedata ->

            livedata.let {

                livedata.result!!.resultObject.forEach {
                    if (it.key == 1) {
                        binding.abonelikText.text = it.value
                    }
                    if (it.key == 2) {
                        binding.dilekcetext.text = it.value
                    }
                    if (it.key == 4) {
                        binding.tahliyetext.text = it.value
                    }
                    if (it.key == 5) {
                        binding.nakiltext.text = it.value
                    }
                }

            }
        })

        viewModel.dataLoading.observe(viewLifecycleOwner, Observer { loading ->

            loading.let {
                if (it) {
                    binding.dataLoading.visibility = View.VISIBLE
                } else {
                    binding.dataLoading.visibility = View.GONE
                }
            }
        })

        viewModel.dataError.observe(viewLifecycleOwner, Observer { error ->

            error.let {
                if (it) {
                    binding.dataError.visibility = View.VISIBLE
                } else {
                    binding.dataError.visibility = View.GONE
                }
            }
        })
    }

    private fun swipeRefresh() {

        binding.swipeRefreshLayout.setOnRefreshListener {

            binding.dataError.visibility = View.GONE
            binding.dataLoading.visibility = View.VISIBLE
            viewModel.refreshData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }



}