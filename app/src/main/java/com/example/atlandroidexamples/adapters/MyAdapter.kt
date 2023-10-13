package com.example.atlandroidexamples.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atlandroidexamples.activities.ThirdActivity
import com.example.atlandroidexamples.databinding.ItemListBinding
import com.example.atlandroidexamples.model.Coffee

class MyAdapter(private val data: MutableList<Coffee>):
    RecyclerView.Adapter<MyViewHolder>() {

//    private var onItemClick: ((name: ThirdActivity.Coffee)-> Unit)? = null
//
//    private var onItemClickListener: ListItemClickListener? = null
//
//    fun setOnItemClick(onClick: (name: ThirdActivity.Coffee) -> Unit){
//        onItemClick = onClick
//    }
//
//    fun setOnItemClickLister(listener: ListItemClickListener){
//        onItemClickListener = listener
//    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
//        holder.onBind(data[position], onItemClickListener)
    }


    interface ListItemClickListener{
        fun onItemClick(data: Coffee)
        fun onDeleteClick()
    }
}