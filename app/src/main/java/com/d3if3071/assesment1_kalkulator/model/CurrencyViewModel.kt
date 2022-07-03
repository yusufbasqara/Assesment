package com.d3if3071.assesment1_kalkulator.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if3071.assesment1_kalkulator.model.CurrencyModel
import com.d3if3071.assesment1_kalkulator.network.DataApi
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class CurrencyViewModel : ViewModel(){
    private val data = MutableLiveData<List<CurrencyModel>>()
    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val result = DataApi.service.getData()
                data.postValue(DataApi.service.getData())
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }

    fun getData():LiveData<List<CurrencyModel>> = data

}