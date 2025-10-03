package com.mlbdev.anmp_miniproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mlbdev.anmp_miniproject.R
import com.mlbdev.anmp_miniproject.databinding.FragmentProfilAnakBinding

class FragmentProfilAnak : Fragment() {
    private lateinit var binding: FragmentProfilAnakBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfilAnakBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("ProfilAnak", Context.MODE_PRIVATE)

        binding.txtNama.setText(sharedPreferences.getString("nama",""))
        binding.txtTanggalLahir.setText(sharedPreferences.getString("tanggal",""))

        val gender = sharedPreferences.getString("gender","")
        if(gender == "Laki-laki"){
            binding.rdGender.check(binding.rdbLaki2.id)
        }else if(gender == "Perempuan"){
            binding.rdGender.check(binding.rdbPerempuan.id)
        }

        binding.btnSimpan.setOnClickListener {
            val nama = binding.txtNama.text.toString()
            val tanggal = binding.txtTanggalLahir.text.toString()
            val selecedId = binding.rdGender.checkedRadioButtonId
            val genderValue = if(selecedId == binding.rdbLaki2.id) "Laki-laki" else "Perempuan"

            val editor = sharedPreferences.edit()
            editor.putString("nama", nama)
            editor.putString("tanggal", tanggal)
            editor.putString("gender",genderValue)
            editor.apply()

            Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()

        }
    }
}