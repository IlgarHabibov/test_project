package com.example.atlandroidexamples.lessons.lesson18

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private var name: String? = null
    private var surname: String? = null
    private var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.actionBar?.title = "ThirdFragment"
        name = arguments?.getString("name")
        surname = arguments?.getString("surname")
        age = arguments?.getInt("age")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.text.text = name
        binding.backButton.setOnClickListener {
            parentFragmentManager.setFragmentResult("Result", bundleOf("count" to 19))
            parentFragmentManager.popBackStack()
        }
    }

}