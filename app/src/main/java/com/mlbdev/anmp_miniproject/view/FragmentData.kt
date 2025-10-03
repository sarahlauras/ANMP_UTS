package com.mlbdev.anmp_miniproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mlbdev.anmp_miniproject.R
import com.mlbdev.anmp_miniproject.databinding.FragmentDataBinding
//import com.mlbdev.anmp_miniproject.viewmodel.ListViewModel


class FragmentData : Fragment() {
//    private lateinit var viewModel: ListViewModel
//    private val dataListAdapter  = DataListAdapter(arrayListOf())
    
    private lateinit var binding:FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }
}