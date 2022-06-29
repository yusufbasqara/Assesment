package com.d3if3071.assesment1_kalkulator.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3071.assesment1_kalkulator.db.KalkulatorDao
import com.d3if3071.assesment1_kalkulator.db.KalkulatorEntity
import com.d3if3071.assesment1_kalkulator.model.HasilLuas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel(private val db: KalkulatorDao) : ViewModel() {
    private val hasilLuas = MutableLiveData<HasilLuas?>()

    fun hitungLuas(panjang: Float, tinggi: Float, lebar: Float) {
        val hasilBangunRuang =  (panjang * lebar * tinggi)
        hasilLuas.value = HasilLuas(hasilBangunRuang)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataKalkulator = KalkulatorEntity(
                    panjang = panjang,
                    tinggi = tinggi,
                    lebar = lebar,
                )
                db.insert(dataKalkulator)
            }
        }

    }

    fun getHasilLuas(): LiveData<HasilLuas?> = hasilLuas
}