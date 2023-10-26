package com.example.atlandroidexamples.practice10.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentP10FirstBinding
import com.example.atlandroidexamples.databinding.FragmentP10FourthBinding
import com.example.atlandroidexamples.utils.SharedPrefs

class P10FourthFragment : Fragment() {

    private lateinit var binding: FragmentP10FourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentP10FourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            SharedPrefs.putBool(SharedPrefs.SECOND_GRAPH_DONE, true)
            findNavController().navigate(P10FourthFragmentDirections.actionP10FourthFragmentToP10ThirdGraph())
        }
    }


}