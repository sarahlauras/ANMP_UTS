package com.mlbdev.anmp_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mlbdev.anmp_miniproject.model.DataProfilAnak
import com.mlbdev.anmp_miniproject.util.buildProfilDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProfilAnakViewModel(app: Application):AndroidViewModel(app), CoroutineScope {
    val profilLD = MutableLiveData<DataProfilAnak>()
    val loadingLD = MutableLiveData<Boolean>()
    val errorLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        loadingLD.postValue(true)
        errorLD.postValue(false)

        launch {
            val db = buildProfilDB(getApplication())
            val profil = db.profilAnakDao().getProfilAnak()

            if (profil == null) {
                val defaultProfil = DataProfilAnak(
                    name = "Justin Bieber",
                    dob = "07/12/2025",
                    gender = "Laki-laki"
                )
                db.profilAnakDao().insertProfil(defaultProfil)
                profilLD.postValue(defaultProfil)
            } else {
                profilLD.postValue(profil)
            }

            loadingLD.postValue(false)
        }
    }

    fun updateProfil(profil: DataProfilAnak) {
        launch {
            val db = buildProfilDB(getApplication())
            db.profilAnakDao().updateProfilAnak(profil)
            refresh()
        }
    }
}