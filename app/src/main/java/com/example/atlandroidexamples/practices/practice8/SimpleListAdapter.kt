package com.example.atlandroidexamples.practices.practice8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemListBinding
import com.example.atlandroidexamples.databinding.ItemTaskViewPagerBinding

class SimpleListAdapter(private val dataList: List<String>): RecyclerView.Adapter<SimpleListAdapter.SimpleListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return SimpleListViewHolder(binding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    class SimpleListViewHolder(private val binding: ItemListBinding): ViewHolder(binding.root){
        fun bind(data: String){
            binding.labelItem.text = data
        }
    }

}



class SimpleListAdapter2(): RecyclerView.Adapter<SimpleListAdapter2.SimpleListViewHolder2>() {

    private val dataList = mutableListOf<String>()

    fun addNewData(data: String){
        dataList.add(data)
        notifyDataSetChanged()
    }

    fun addNewDataList(data: List<String>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder2 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return SimpleListViewHolder2(binding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: SimpleListViewHolder2, position: Int) {
        holder.bind(dataList[position])
    }

    class SimpleListViewHolder2(private val binding: ItemListBinding): ViewHolder(binding.root){
        fun bind(data: String){
            binding.labelItem.text = data
        }
    }

}