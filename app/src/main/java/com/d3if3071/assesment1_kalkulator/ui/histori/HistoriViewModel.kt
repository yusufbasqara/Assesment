package com.d3if3071.assesment1_kalkulator.ui.histori

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3071.assesment1_kalkulator.db.KalkulatorDao
import com.d3if3071.assesment1_kalkulator.network.DataApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoriViewModel(private val db: KalkulatorDao) : ViewModel() {
    val data = db.getLastKalkulator()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}