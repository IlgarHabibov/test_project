package com.example.atlandroidexamples.practices.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemSettingsBinding

class SettingsAdapter(private val dataList: List<SettingsModel>):
    RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {


    private var onItemClickListener: OnSettingsItemClick? = null

    fun setOnItemClick(clickListener: OnSettingsItemClick){
        onItemClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSettingsBinding.inflate(inflater, parent, false)
        return SettingsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        holder.bind(dataList[position], onItemClickListener)
    }

    class SettingsViewHolder(private val binding: ItemSettingsBinding): ViewHolder(binding.root){
        fun bind(data: SettingsModel, clickListener: OnSettingsItemClick?){
            binding.imageSettingsItem.setImageResource(data.iconResId)
            binding.labelNameSettingsItem.text = data.name
            binding.parentSettingsItem.setOnClickListener {
                clickListener?.onItemClick(data)
            }
        }
    }

    interface OnSettingsItemClick{
        fun onItemClick(settingsData: SettingsModel)
    }
}