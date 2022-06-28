package com.d3if3071.assesment1_kalkulator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.d3if3071.assesment1_kalkulator.databinding.FragmentHasilBinding

class HasilFragment : Fragment() {
    private lateinit var binding: FragmentHasilBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHasilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}