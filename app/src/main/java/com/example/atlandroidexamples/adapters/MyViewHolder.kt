package com.example.atlandroidexamples.adapters

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemListBinding
import com.example.atlandroidexamples.model.Coffee

class MyViewHolder(
    private val binding: ItemListBinding
): ViewHolder(binding.root) {

    fun onBind(data: Coffee, onItemClick: MyAdapter.ListItemClickListener?){
        binding.labelItem.text = data.name
        binding.labelItem.setOnClickListener {
            onItemClick?.onItemClick(data)
        }

    }
}
