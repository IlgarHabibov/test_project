package com.example.atlandroidexamples.practice9.getstarted

import android.net.Uri
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.text.toSpannable
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentWelcomeBinding
import com.example.atlandroidexamples.utils.SharedPrefs


class WelcomeFragment : Fragment() {


    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getStartedButton.setOnClickListener {
            val action = WelcomeFragmentDirections
                .actionWelcomeFragment2ToNestedFlow(
                    coffeeId = "Ilgar",
                    coffeeName = "Habibov"
                )
            SharedPrefs.putBool(SharedPrefs.IS_WELCOME_DONE, true)
            findNavController().navigate(action)


        }
    }

}