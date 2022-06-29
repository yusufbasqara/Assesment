package com.d3if3071.assesment1_kalkulator.ui.histori

import android.graphics.drawable.GradientDrawable
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.d3if3071.assesment1_kalkulator.R
import com.d3if3071.assesment1_kalkulator.databinding.ItemHistoriBinding
import com.d3if3071.assesment1_kalkulator.db.KalkulatorEntity
import com.d3if3071.assesment1_kalkulator.model.hitungKalkulator
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter:
    ListAdapter<KalkulatorEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<KalkulatorEntity>() {
                override fun areItemsTheSame(
                    oldData: KalkulatorEntity, newData: KalkulatorEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: KalkulatorEntity, newData: KalkulatorEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }
    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID"))
        fun bind(item: KalkulatorEntity) = with(binding) {
            val hasilLuas = item.hitungKalkulator()


            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            kalkulatorTextView.text =  hasilLuas.hasilBangunRuang.toString()
            dataTextView.text = item.jenis

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}