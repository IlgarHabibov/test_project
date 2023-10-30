package com.example.atlandroidexamples.practices.practice8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemPagerBinding
import com.example.atlandroidexamples.databinding.ItemPhotoTextBinding
import com.example.atlandroidexamples.databinding.ItemTaskViewPagerBinding

class TaskPagerAdapter(private val dataList: List<PagerTaskModel>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            PENDING -> {
                val binding = ItemTaskViewPagerBinding.inflate(inflater, parent, false)
                 PendingViewHolder(binding)
            }
            DELIVERED -> {
                val binding = ItemTaskViewPagerBinding.inflate(inflater, parent, false)
                DeliveredViewHolder(binding)
            }
             else -> {
                val binding = ItemPhotoTextBinding.inflate(inflater, parent, false)
                 PhotoViewHolder(binding)
            }
        }

    }

    override fun getItemCount() = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when(dataList[position]){
            is PagerTaskModel.Pending -> PENDING
            is PagerTaskModel.Delivered -> DELIVERED
            is PagerTaskModel.PhotoWithText -> PHOTO_TEXT
            is PagerTaskModel.PhotoWithButton -> PHOTO_BUTTON
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is PendingViewHolder ->{
                holder.bind(dataList[position] as PagerTaskModel.Pending)
            }
            is DeliveredViewHolder ->{
                holder.bind(dataList[position] as PagerTaskModel.Delivered)
            }
            is PhotoViewHolder ->{
                holder.bind(dataList[position] as PagerTaskModel.PhotoWithText)
            }
        }
    }

    class PendingViewHolder(private val binding: ItemTaskViewPagerBinding)
        : ViewHolder(binding.root){

        fun bind(data: PagerTaskModel.Pending){
            val adapter = SimpleListAdapter(data.list)
            binding.taskRecyclerView.adapter = adapter
        }
    }

    class DeliveredViewHolder(private val binding: ItemTaskViewPagerBinding)
        : ViewHolder(binding.root){

        fun bind(data: PagerTaskModel.Delivered){
            val adapter = SimpleListAdapter(data.list)
            binding.taskRecyclerView.adapter = adapter
        }
    }

    class PhotoViewHolder(private val binding: ItemPhotoTextBinding)
        : ViewHolder(binding.root){

        fun bind(data: PagerTaskModel.PhotoWithText){
           binding.imageViewTask.setImageResource(data.imageId)
           binding.textListItem.text = data.text
        }
    }

    companion object{
        private const val DELIVERED = 1
        private const val PENDING = 2
        private const val PHOTO_TEXT = 3
        private const val PHOTO_BUTTON = 4

    }
}