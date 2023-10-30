package com.example.atlandroidexamples.lessons.lesson24.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemNoteBinding
import com.example.atlandroidexamples.db.entities.TextEntity
import com.example.atlandroidexamples.practices.practice11.OnNoteClickListener

class SimpleListAdapter: RecyclerView.Adapter<SimpleListAdapter.SimpleListViewHolder>(){

    private val dataList = mutableListOf<TextEntity>()
    private var clickListener: OnNoteClickListener? = null

    fun updateData(newList: List<TextEntity>){
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: OnNoteClickListener){
        this.clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        return SimpleListViewHolder(binding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        holder.bind(dataList[position], clickListener)
    }


    class SimpleListViewHolder(val binding: ItemNoteBinding): ViewHolder(binding.root){
        fun bind(data: TextEntity, clickListener: OnNoteClickListener?){
            binding.title.text = data.text
            binding.deleteButton.setOnClickListener {
                clickListener?.onItemDeleteClick(data)
            }

            binding.title.setOnClickListener {
                clickListener?.onItemClick(data)
            }
        }
    }
}

