package com.example.atlandroidexamples.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.atlandroidexamples.databinding.ItemListBinding

class MyPagerAdapter(private val dataList: List<String>): PagerAdapter() {
    override fun getCount(): Int {
        return  dataList.size
    }

    override fun isViewFromObject(view: View, anyObject: Any): Boolean {
        return view === anyObject
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val binding = ItemListBinding.inflate(inflater, container, false)
        binding.labelItem.text = dataList[position]
        when(dataList[position]){
            
        }
        return binding.root
    }
}