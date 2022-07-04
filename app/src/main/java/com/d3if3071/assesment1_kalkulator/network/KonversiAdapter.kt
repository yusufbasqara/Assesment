package com.d3if3071.assesment1_kalkulator.network

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.d3if3071.assesment1_kalkulator.R
import com.d3if3071.assesment1_kalkulator.databinding.ItemKonversiBinding
import com.d3if3071.assesment1_kalkulator.model.CurrencyModel

class  KonversiAdapter : RecyclerView.Adapter<KonversiAdapter.ViewHolder>() {
    private val data = mutableListOf<CurrencyModel>()

    fun updateData(newData: List<CurrencyModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemKonversiBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(
        private val binding: ItemKonversiBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: CurrencyModel) = with(binding) {
            TextView1.text = currency.base
            TextView2.text = currency.date
//            Glide.with(imageView.context)
//                .load(HewanApi.getHewanUrl(hewan.imageId))
//                .error(R.drawable.ic_baseline_broken_image_24)
//                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, currency.base)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }
}