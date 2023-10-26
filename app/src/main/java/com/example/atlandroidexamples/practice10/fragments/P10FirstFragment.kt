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
import com.example.atlandroidexamples.practice10.viewmodel.MyViewModel
import com.example.atlandroidexamples.practice10.viewmodel.MyViewModelFactory

class P10FirstFragment : Fragment() {

    private lateinit var binding: FragmentP10FirstBinding


//    private val viewModelFactory = MyViewModelFactory("Test")
//    private val viewModel = viewModelFactory.create(MyViewModel::class.java)

    private val viewModel: MyViewModel by viewModels { MyViewModel.Factory }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentP10FirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        viewModel.myLiveData.observe(viewLifecycleOwner){data ->
//            binding.title.text = data.toString()
//        }

        binding.nextButton.setOnClickListener {
            findNavController().navigate(
                P10FirstFragmentDirections
                    .actionP10FirstFragmentToP10SecondFragment(testId = "test")
            )
        }
    }

}