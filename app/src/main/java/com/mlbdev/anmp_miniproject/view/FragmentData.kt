package com.mlbdev.anmp_miniproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlbdev.anmp_miniproject.R
import com.mlbdev.anmp_miniproject.databinding.FragmentDataBinding
import com.mlbdev.anmp_miniproject.viewmodel.ListViewModel



class FragmentData : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val dataListAdapter  = DataListAdapter(arrayListOf())
    
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
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.loadData()

        binding.recViewData.layoutManager = LinearLayoutManager(context)
        binding.recViewData.adapter = dataListAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.dataLD.observe(viewLifecycleOwner, Observer {
            dataListAdapter.updateDataList(it)
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it == true){
                binding.recViewData.visibility =View.INVISIBLE
                binding.progressLoad.visibility = View.VISIBLE
            } else{
                binding.recViewData.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.INVISIBLE
            }
        })
    }
}