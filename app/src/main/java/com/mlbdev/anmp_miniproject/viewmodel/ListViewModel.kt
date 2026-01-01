package com.mlbdev.anmp_miniproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mlbdev.anmp_miniproject.model.DataUkur
import com.mlbdev.anmp_miniproject.util.FileHelper
import com.mlbdev.anmp_miniproject.util.buildUkurDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListViewModel(app: Application):AndroidViewModel(app), CoroutineScope {
    val dataLD = MutableLiveData<List<DataUkur>>()
    val errorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh(){
        loadingLD.value = true
        errorLD.value = false

        launch {
            val db = buildUkurDB(getApplication())
            dataLD.postValue(db.ukurDao().SelectAll())
            loadingLD.postValue(false)
        }
    }

    fun loadData(){
//        loadingLD.value = true
//        errorLD.value = false
//
//        try {
//            val filehelper = FileHelper(getApplication())
//            val dataJson = filehelper.readFromFile()
//
//            if (!dataJson.isNullOrEmpty()) {
//                val sType = object : TypeToken<List<DataUkur>>() {}.type
//                val hasil = Gson().fromJson<List<DataUkur>>(dataJson, sType)
//                dataLD.value = ArrayList(hasil)
//                Log.d( "getdatahasil" ,hasil.toString())
//            } else {
//                dataLD.value = arrayListOf()
//            }
//            loadingLD.value = false
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//            dataLD.value = arrayListOf()
//            loadingLD.value = false
//            errorLD.value = true
//        }
    }

    fun addData(newData: DataUkur){
        launch {
            val db = buildUkurDB(getApplication())
            db.ukurDao().InsertAll(newData)
        }

//        val fileHelper = FileHelper(getApplication())
//        val sType = object : TypeToken<List<DataUkur>>() {}.type
//
//        val dataJson = fileHelper.readFromFile()
//
//        val currentList: ArrayList<DataUkur> = if (dataJson.isNotEmpty()) {
//            try {
//                ArrayList(Gson().fromJson<List<DataUkur>>(dataJson, sType))
//            } catch (e: Exception) {
//                ArrayList()
//            }
//        } else {
//            ArrayList()
//        }
//
//        currentList.add(newData)
//
//        val updatedJson = Gson().toJson(currentList)
//        fileHelper.writeToFile(updatedJson)
//        dataLD.value = currentList
//        testSaveFile()
    }

    fun testSaveFile(){
        val filehelper = FileHelper(getApplication())
        val content = filehelper.readFromFile()
        Log.d("print file ", content)
        Log.d("print file ", filehelper.getFilePath())
    }

}