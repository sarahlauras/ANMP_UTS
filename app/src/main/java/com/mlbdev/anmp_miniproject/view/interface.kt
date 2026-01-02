package com.mlbdev.anmp_miniproject.view

import com.mlbdev.anmp_miniproject.model.DataUkur
import android.view.View
import com.mlbdev.anmp_miniproject.model.DataProfilAnak

interface DataUkurListener{
    fun onTambahClick(obj: DataUkur)
}

interface ProfilanakListener{
    fun OnGenderSelected(gender: String)
    fun OnEditClick(obj: DataProfilAnak)
}