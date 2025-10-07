package com.mlbdev.anmp_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import com.mlbdev.anmp_miniproject.model.DataUkur
import com.mlbdev.anmp_miniproject.util.FileHelper

class ListViewModel(app: Application):AndroidViewModel(app) {
    val dataLD = MutableLiveData<ArrayList<DataUkur>>()
    val errorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun loadData(){
        loadingLD.value = true
        errorLD.value = false

        try{
            val filehelper = FileHelper(getApplication())
            val dataJson = filehelper.readFromFile()

            if (!dataJson.isNullOrEmpty()) {
                val sType = object: TypeToken<List<DataUkur>>() {}.type
                val hasil = Gson().fromJson<List<DataUkur>>(dataJson, sType)
                dataLD.value = ArrayList(hasil)
            }else{
                dataLD.value = arrayListOf()
            }
        }catch(e: Exception) {
            e.printStackTrace()
            dataLD.value = arrayListOf()
            loadingLD.value = false
        }
    }

    fun addData(newData: DataUkur){
        val fileHelper = FileHelper(getApplication())
        val dataJson = fileHelper.readFromFile()

        val currentList =
            if (dataJson.isNotEmpty()) {
                val sType = object: TypeToken<List<DataUkur>>() {}.type
                ArrayList(Gson().fromJson<List<DataUkur>>(dataJson, sType))
            } else {
                ArrayList()
            }

        currentList.add(newData)

        // simpan ke file JSON
        val updatedJson = Gson().toJson(currentList)
        fileHelper.writeToFile(updatedJson)

        // update LiveData biar UI refresh
        dataLD.value = currentList
    }
}