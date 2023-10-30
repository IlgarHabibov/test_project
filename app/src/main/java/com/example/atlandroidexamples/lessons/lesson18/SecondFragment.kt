package com.example.atlandroidexamples.lessons.lesson18

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private  var binding: FragmentSecondBinding? = null
    private var name: String? = null
    private var surname: String? = null
    private var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.actionBar?.setDisplayShowHomeEnabled(true)
        activity?.actionBar?.title = "SecondFragment"
        name = arguments?.getString("name")
        surname = arguments?.getString("surname")
        age = arguments?.getInt("age")

    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding?.text?.text = "$name $surname $age"
        binding?.backButton?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding?.nextButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(SecondFragment::class.java.canonicalName)
                .replace(R.id.fragmentContainer, ThirdFragment())
                .commit()
        }
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}