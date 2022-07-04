package com.d3if3071.assesment1_kalkulator.ui.konversi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if3071.assesment1_kalkulator.model.GaleriModel
import com.d3if3071.assesment1_kalkulator.network.DataApi
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class GaleriViewModel : ViewModel(){
    private val data = MutableLiveData<List<GaleriModel>>()
    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val result = DataApi.service.getData()
                data.postValue(result)
                Log.d("MainViewModel", "Success: $result")
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }

    fun getData():LiveData<List<GaleriModel>> = data

}