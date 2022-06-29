package com.d3if3071.assesment1_kalkulator.ui.hitung

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.d3if3071.assesment1_kalkulator.R
import com.d3if3071.assesment1_kalkulator.databinding.FragmentHitungBinding
import com.d3if3071.assesment1_kalkulator.db.KalkulatorDb
import com.d3if3071.assesment1_kalkulator.model.HasilLuas

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    private val viewModel: HitungViewModel by lazy {
        val db = KalkulatorDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { hitungLuas() }
        binding.hasilButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_hasilFragment
            )
        }
        binding.shareButton.setOnClickListener { shareData() }
        viewModel.getHasilLuas().observe(requireActivity(), { showResult(it) })
        

    }

    private fun shareData() {
        val selectedId = binding.radioGroup.checkedRadioButtonId
        val jenisRuang = if (selectedId == R.id.persegiButton)
            getString(R.string.persegi_panjang)
        else if (selectedId == R.id.kubikButton)
            getString(R.string.kubik)
        else
            getString(R.string.balok)
        val message = getString(R.string.bagikan_template,
            binding.editTextNumber.text,
            binding.editTextNumber2.text,
            binding.editTextNumber3.text,
            jenisRuang,
            binding.hasilLuas.text,
            binding.hasilButton.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

    private fun reset() {
        binding.editTextNumber.text.clear()
        binding.editTextNumber2.text.clear()
        binding.editTextNumber3.text.clear()
        binding.radioGroup.clearCheck()
        binding.hasilLuas.text = getString(R.string.luas_bangun)

    }

    private fun showResult(result: HasilLuas? ) {
        if (result == null) return
        binding.hasilLuas.text = getString(R.string.luas_bangun, result.hasilBangunRuang)
        binding.hasilButton.visibility = View.VISIBLE

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_hitungFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_hitungFragment_to_aboutFragment
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hitungLuas() {
        val panjang = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_SHORT).show()
        }


        val lebar = binding.editTextNumber2.text.toString()
        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(context, R.string.lebar_invalid, Toast.LENGTH_SHORT).show()
        }

        val tinggi = binding.editTextNumber3.text.toString()


        val selectedId = binding.radioGroup.checkedRadioButtonId

        if (selectedId == 2131230956 || selectedId == 2131230807) {
            if (TextUtils.isEmpty(tinggi)) {
                Toast.makeText(context, R.string.tinggi_invalid, Toast.LENGTH_SHORT).show()
            }
            if (!TextUtils.isEmpty(panjang) && !TextUtils.isEmpty(lebar) && !TextUtils.isEmpty(
                    tinggi
                )
            ) {
               viewModel.hitungLuas(
                   panjang.toFloat(),
                   tinggi.toFloat(),
                   lebar.toFloat()
               )
            }
        } else {
            val hasilBangunDatar = panjang.toDouble() * lebar.toDouble()
            binding.hasilLuas.text = hasilBangunDatar.toString()
        }

        Log.d("check id", selectedId.toString())
    }
}