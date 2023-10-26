package com.example.atlandroidexamples.practice10.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentP10FirstBinding
import com.example.atlandroidexamples.databinding.FragmentP10SixthBinding

class P10SixthFragment : Fragment() {

    private lateinit var binding: FragmentP10SixthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentP10SixthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}