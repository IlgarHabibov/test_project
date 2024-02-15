package com.example.atlandroidexamples.practices.practice20

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemSideMenuBinding

class SideMenuAdapter(
    private val list: MutableList<MenuItem>,
    private val onItemClick: (item: MenuItem) -> Unit
): Adapter<SideMenuAdapter.SideMenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SideMenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSideMenuBinding.inflate(inflater, parent, false)
        return SideMenuViewHolder(binding)
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: SideMenuViewHolder, position: Int) {
        holder.bind(list[position], onItemClick)
    }



    class SideMenuViewHolder(
        val binding: ItemSideMenuBinding
    ): ViewHolder(binding.root){

        fun bind(data: MenuItem, onItemClick: (item: MenuItem) -> Unit){
            with(binding){
                labelMenu.text = data.title
                labelMenu.setOnClickListener {
                    onItemClick.invoke(data)
                }
            }
        }
    }
}