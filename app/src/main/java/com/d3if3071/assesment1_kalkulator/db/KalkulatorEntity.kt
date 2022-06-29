package com.d3if3071.assesment1_kalkulator.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kalkulator")
data class KalkulatorEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var panjang: Float,
    var lebar: Float,
    var tinggi: Float,
)
