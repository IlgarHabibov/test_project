package com.example.atlandroidexamples.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atlandroidexamples.databinding.ItemCoffeeBinding
import com.example.atlandroidexamples.model.Coffee

class CoffeeAdapter(private val coffeeList: List<Coffee>) :
    RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    fun setItemClickListener(clickListener: OnItemClickListener) {
//        onItemClickListener = clickListener
    }

    var onClickListener: ((coffee: Coffee) -> Unit)? = null

    fun setClickListener(listener:(coffee: Coffee) -> Unit){
        onClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val binding = ItemCoffeeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoffeeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(coffeeList[position], onItemClickListener, onClickListener)
    }

    class CoffeeViewHolder(private val binding: ItemCoffeeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Coffee, onClickListener: OnItemClickListener?, clickListener: ((coffee: Coffee) -> Unit)?) {
            binding.name.text = data.name
            binding.desc.text = data.desc
            binding.priceChocolate.text = data.price.toString()
            binding.ratingChocolate.text = data.rating
            binding.imageChocolate.setImageResource(data.iconId)
            binding.parentChocolate.setOnClickListener {
                onClickListener?.onItemClick(data)

                clickListener?.invoke(data)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(coffee: Coffee)
    }

}