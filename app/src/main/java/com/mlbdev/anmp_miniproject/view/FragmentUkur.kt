package com.mlbdev.anmp_miniproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.mlbdev.anmp_miniproject.R
import com.mlbdev.anmp_miniproject.databinding.FragmentUkurBinding
import com.mlbdev.anmp_miniproject.model.DataUkur
import com.mlbdev.anmp_miniproject.viewmodel.ListViewModel

class FragmentUkur : Fragment() {
    private lateinit var binding: FragmentUkurBinding
    private lateinit var viewmodel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUkurBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(ListViewModel::class.java) //cara nge init view model

        binding.btnUkur.setOnClickListener {
            val age = binding.txtUmur.text.toString().toInt()
            val weight = binding.txtBerat.text.toString().toInt()
            val height = binding.txtTinggi.text.toString().toInt()

            val newData = DataUkur(age, weight, height)
            viewmodel.addData(newData)

            Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()

            binding.txtUmur.text.clear()
            binding.txtBerat.text.clear()
            binding.txtTinggi.text.clear()
        }
    }
}