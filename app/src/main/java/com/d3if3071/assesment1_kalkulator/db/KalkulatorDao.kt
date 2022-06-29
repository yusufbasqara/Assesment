package com.d3if3071.assesment1_kalkulator.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KalkulatorDao {
    @Insert
    fun insert(kalkulator: KalkulatorEntity)
    @Query("SELECT * FROM kalkulator ORDER BY id DESC")
    fun getLastKalkulator(): LiveData<List<KalkulatorEntity>>

}