package com.d3if3071.assesment1_kalkulator.model

import com.d3if3071.assesment1_kalkulator.db.KalkulatorEntity

fun KalkulatorEntity.hitungKalkulator(): HasilLuas {
    val kalkulator = panjang * lebar * tinggi

    return HasilLuas(kalkulator)
}