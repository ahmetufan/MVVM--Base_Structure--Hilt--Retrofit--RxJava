package com.ahmet.enerjisa.view

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.ahmet.enerjisa.R
import com.ahmet.enerjisa.databinding.FragmentFormBinding
import com.ahmet.enerjisa.view.base.BaseFragment
import com.ahmet.enerjisa.viewmodel.FormViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormFragment : BaseFragment<FragmentFormBinding, FormViewModel>() {

    override val viewModel: FormViewModel by viewModels()

    override fun getViewBinding() = FragmentFormBinding.inflate(layoutInflater)

    override fun onFragmentCreated() {}


    override fun observe() {

        binding.radiogruop.setOnCheckedChangeListener { radioGroup, chechkedId ->
            //Fonksiyon
        }


        val abone_tipi = resources.getStringArray(R.array.Abone_Tipi)

        val adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, abone_tipi)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //Fonksyion
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.imageView7.setOnClickListener {
            if (binding.expandLayout.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(binding.cardView5, AutoTransition())
                binding.expandLayout.visibility = View.VISIBLE
                binding.SonrakiBtn.visibility = View.GONE
            } else {
                TransitionManager.beginDelayedTransition(binding.cardView5, AutoTransition())
                binding.expandLayout.visibility = View.GONE
                binding.SonrakiBtn.visibility = View.VISIBLE
            }
        }
        binding.expandButton.setOnClickListener {
            if (binding.expandLayout.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(binding.cardView5, AutoTransition())
                binding.expandLayout.visibility = View.VISIBLE
                binding.SonrakiBtn.visibility = View.GONE
            } else {
                TransitionManager.beginDelayedTransition(binding.cardView5, AutoTransition())
                binding.expandLayout.visibility = View.GONE
                binding.SonrakiBtn.visibility = View.VISIBLE
            }
        }

        binding.imageFormBack.setOnClickListener {
            activity!!.onBackPressed()
        }


    }

}