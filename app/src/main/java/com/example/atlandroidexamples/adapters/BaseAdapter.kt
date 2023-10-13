package com.example.atlandroidexamples.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<D, VH: ViewHolder>: RecyclerView.Adapter<VH>() {

    protected val dataList = mutableListOf<D>()

    fun addNewData(newDataList: List<D>){
        dataList.clear()
        dataList.addAll(newDataList)
        newDataList
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}