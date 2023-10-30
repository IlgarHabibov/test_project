package com.example.atlandroidexamples.practices.practice10.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentP10FifthBinding
import com.example.atlandroidexamples.databinding.FragmentP10FirstBinding
import com.example.atlandroidexamples.practices.practice10.model.State
import com.example.atlandroidexamples.practices.practice10.viewmodel.EmptyViewModel


class P10FifthFragment : Fragment() {


    private lateinit var binding: FragmentP10FifthBinding

    private val viewModel: EmptyViewModel by viewModels()

//    private val factory = TestViewModelFactory("Ilgar")
//    private val viewModel2 = factory.create(TestViewModel::class.java)
//
//    private val viewModel3 by viewModels<TestViewModel> { TestViewModel.factory("Ilgar") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentP10FifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveData.observe(viewLifecycleOwner){state ->
            when(state){
                is State.Success ->{
                    binding.progressBar.isVisible = false
                    binding.title.text = state.data.toString()
                }
                is State.Error ->{
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
                is State.Loading ->{
                    binding.progressBar.isVisible = true
                }
                is State.None ->{
                    binding.progressBar.isVisible = false
                }
            }
        }

        binding.nextButton.setOnClickListener {

//            findNavController().navigate(P10FifthFragmentDirections.actionP10FifthFragmentToP10SixthFragment())
        }


        binding.increaseButton.setOnClickListener {
            viewModel.increase()
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}