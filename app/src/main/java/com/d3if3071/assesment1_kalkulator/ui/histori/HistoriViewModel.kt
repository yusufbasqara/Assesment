package com.d3if3071.assesment1_kalkulator.ui.histori

import androidx.lifecycle.ViewModel
import com.d3if3071.assesment1_kalkulator.db.KalkulatorDao

class HistoriViewModel(db: KalkulatorDao) : ViewModel() {
    val data = db.getLastKalkulator()
}