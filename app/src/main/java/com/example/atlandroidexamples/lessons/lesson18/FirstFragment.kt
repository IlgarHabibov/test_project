package com.example.atlandroidexamples.lessons.lesson18

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
//            binding.textFragment.text = "Done"
            openNextPage()
        }


        parentFragmentManager
            .setFragmentResultListener("Result", viewLifecycleOwner, ){ key, result ->
                val count = result.getInt("count")
                binding.textFragment.text = count.toString()
            }



    }

    private fun openNextPage(){
        val bundle = bundleOf(
            "name" to "Ilgar",
            "surname" to "Habibov",
            "age" to 32
        )

        parentFragmentManager.beginTransaction()
            .addToBackStack(FirstFragment::class.java.canonicalName)
            .replace(R.id.fragmentContainer, SecondFragment::class.java, bundle)
            .commit()

    }

}