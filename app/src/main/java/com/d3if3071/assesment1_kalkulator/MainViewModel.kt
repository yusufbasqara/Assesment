package com.d3if3071.assesment1_kalkulator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if3071.assesment1_kalkulator.model.HasilLuas

class MainViewModel : ViewModel() {
    private val hasilLuas = MutableLiveData<HasilLuas?>()

    fun hitungLuas(panjang: Float, tinggi: Float, lebar: Float) {
        val hasilBangunRuang =  (panjang * lebar * tinggi)
        hasilLuas.value = HasilLuas(hasilBangunRuang)
    }

    fun getHasilLuas(): LiveData<HasilLuas?> = hasilLuas
}