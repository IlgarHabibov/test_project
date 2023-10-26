package com.example.atlandroidexamples.practice10.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentP10FirstBinding
import com.example.atlandroidexamples.databinding.FragmentP10SecondBinding
import com.example.atlandroidexamples.practice10.viewmodel.SimpleViewModel
import com.example.atlandroidexamples.utils.SharedPrefs

class P10SecondFragment : Fragment() {


    private lateinit var binding: FragmentP10SecondBinding

    private val viewModel: SimpleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentP10SecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arguments ->
            val args = P10SecondFragmentArgs.fromBundle(arguments)
//            val id = args.testId
//            binding.title.text = id
        }

        binding.nextButton.setOnClickListener {
            SharedPrefs.putBool(SharedPrefs.FIRST_GRAPH_DONE, true)
            findNavController().navigate(P10SecondFragmentDirections.actionP10SecondFragmentToP10SecondGraph())
        }
    }
}