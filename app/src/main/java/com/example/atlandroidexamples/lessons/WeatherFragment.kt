package com.example.atlandroidexamples.lessons

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentWeatherBinding
import com.example.atlandroidexamples.lessons.lesson24.WeatherVM


class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val viewModel by viewModels<WeatherVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.weatherData.observe(viewLifecycleOwner){data ->
            data?.let {
                binding.labelCountry.text = it.name
                binding.labelCity.text = it.phone
                binding.labelTime.text = it.email
//                binding.iconWeather.load("https:" + it.current?.condition?.icon)
                binding.labelStatusWeather.text = "${it.address?.city}  ${it?.address?.street}"
                binding.labelTempWeather.text = "${it.address?.geo?.lat}  ${it?.address?.geo?.lng}"

            }
        }

        binding.plusButton.setOnClickListener {
            viewModel.getWeather()
        }
    }

}