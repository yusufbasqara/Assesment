package com.d3if3071.assesment1_kalkulator.model

data class CurrencyModel(
    val WARNING_UPGRADE_TO_V6: String,
    val base: String,
    val date: String,
    val provider: String,
    val rates: Rates,
    val terms: String,
    val time_last_updated: Int
)