package com.mlbdev.anmp_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlbdev.anmp_miniproject.model.DataUkur

class ListViewModel(app: Application):AndroidViewModel(app) {
    val dataLD = MutableLiveData<ArrayList<DataUkur>>()
    val loadingLD = MutableLiveData<Boolean>()

    fun loadData(){
        loadingLD.value = true

        dataLD.value = arrayListOf(
            DataUkur(162, 50, 21),
            DataUkur(155, 49, 22),
            DataUkur(160, 46, 21)
        )
        loadingLD.value = false
    }
}