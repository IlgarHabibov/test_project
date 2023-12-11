package com.example.atlandroidexamples.lessons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentCoilTestBinding
import com.example.atlandroidexamples.utils.transformations.BlurTransformation
import com.example.atlandroidexamples.utils.transformations.WatermarkTransformation

class CoilTestFragment : Fragment() {


    private lateinit var binding: FragmentCoilTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoilTestBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
        binding.imageViewTest.load(imageUrl){

            val a = "12"
            val list = listOf(1,2,4,4,1,5)

            list.containsDuplicateElements()
        }
    }

}

private fun <E> List<E>.containsDuplicateElements(): Boolean {
    return this.toSet().size != size
}
