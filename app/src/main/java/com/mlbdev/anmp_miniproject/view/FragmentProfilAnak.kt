package com.mlbdev.anmp_miniproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mlbdev.anmp_miniproject.R
import com.mlbdev.anmp_miniproject.databinding.FragmentProfilAnakBinding
import com.mlbdev.anmp_miniproject.model.DataProfilAnak
import com.mlbdev.anmp_miniproject.model.ProfilAnakDao
import com.mlbdev.anmp_miniproject.util.buildProfilDB
import com.mlbdev.anmp_miniproject.viewmodel.ProfilAnakViewModel

class FragmentProfilAnak : Fragment(), ProfilanakListener {
    private lateinit var binding: FragmentProfilAnakBinding
    //private lateinit var sharedPreferences: SharedPreferences
    private lateinit var viewModel: ProfilAnakViewModel
    private var currentProfil: DataProfilAnak? = null

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
        //sharedPreferences = requireActivity().getSharedPreferences("ProfilAnak", Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(ProfilAnakViewModel::class.java)

        binding.listener = this
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.refresh()

        observeViewModel()

//        binding.btnSimpan.setOnClickListener {
//            simpanProfil()
//        }
//        profilAnakDao = buildProfilDB(requireContext())
//        binding.txtNama.setText(sharedPreferences.getString("nama",""))
//        binding.txtTanggalLahir.setText(sharedPreferences.getString("tanggal",""))
//
//        val gender = sharedPreferences.getString("gender","")
//        if(gender == "Laki-laki"){
//            binding.rdGender.check(binding.rdbLaki2.id)
//        }else if(gender == "Perempuan"){
//            binding.rdGender.check(binding.rdbPerempuan.id)
//        }
//
//        binding.btnSimpan.setOnClickListener {
//            val nama = binding.txtNama.text.toString()
//            val tanggal = binding.txtTanggalLahir.text.toString()
//            val selecedId = binding.rdGender.checkedRadioButtonId
//            val genderValue = if(selecedId == binding.rdbLaki2.id) "Laki-laki" else "Perempuan"
//
//            val editor = sharedPreferences.edit()
//            editor.putString("nama", nama)
//            editor.putString("tanggal", tanggal)
//            editor.putString("gender",genderValue)
//            editor.apply()
//
//            Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
//
//        }
    }

    private fun observeViewModel(){
        viewModel.profilLD.observe(viewLifecycleOwner){
            binding.profilanak = it
            currentProfil = it
//            profil ->
//            currentProfil = profil
//            binding.txtNama.setText(profil.name)
//            binding.txtTanggalLahir.setText(profil.dob)
//
//            if(profil.gender == "Laki-laki"){
//                binding.rdGender.check(binding.rdbLaki2.id)
//            }else{
//                binding.rdGender.check(binding.rdbPerempuan.id)
//            }
        }
    }

    private fun simpanProfil(){
        val nama = binding.txtNama.text.toString()
        val tanggal = binding.txtTanggalLahir.text.toString()
        val gender =
            if (binding.rdGender.checkedRadioButtonId == binding.rdbLaki2.id)
                "Laki-laki"
            else
                "Perempuan"

        currentProfil?.let{
            val updatedProfil = it.copy(
                name = nama,
                dob = tanggal,
                gender = gender
            )
            viewModel.updateProfil(updatedProfil)
            Toast.makeText(requireContext(), "Profil berhasil diupdate", Toast.LENGTH_SHORT).show()
        }
    }

    override fun OnGenderSelected(gender: String) {
        binding.profilanak?.gender = gender
    }

    override fun OnEditClick(obj: DataProfilAnak) {
        viewModel.updateProfil(obj)
        Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
        //binding.profilanak = DataProfilAnak("","","")
    }
}