package com.example.atlandroidexamples.practice9.getstarted

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentIntroBinding
import com.example.atlandroidexamples.databinding.FragmentWelcomeBinding
import com.example.atlandroidexamples.practice9.auth.AuthFragment


class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val args = IntroFragmentArgs.fromBundle(requireArguments())
        val coffeeId = args.coffeeId
        val coffeeName = args.coffeeName

//        Toast.makeText(context, "$coffeeId  $coffeeName", Toast.LENGTH_SHORT).show()

        binding.shopNowButton.setOnClickListener {

            findNavController().navigate(R.id.action_introFragment2_to_authFragment)

        }
    }


}