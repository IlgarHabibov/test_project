package com.example.atlandroidexamples.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.ItemButtonBinding
import com.example.atlandroidexamples.databinding.ItemImageBinding
import com.example.atlandroidexamples.databinding.ItemTextBinding

class TypeAdapter(private val dataList: List<TypeDataModel>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            IMAGE_TYPE -> {
                val binding = ItemImageBinding.inflate(inflater, parent, false)
                ImageViewHolder(binding)
            }
            BUTTON_TYPE -> {
                val binding = ItemButtonBinding.inflate(inflater, parent, false)
                ButtonViewHolder(binding)
            }
            else -> {
                val binding = ItemTextBinding.inflate(inflater, parent, false)
                TextViewHolder(binding)
            }
        }
    }

    override fun getItemCount() = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when(dataList[position]){
            is TypeDataModel.Text -> TEXT_TYPE
            is TypeDataModel.Image -> IMAGE_TYPE
            is TypeDataModel.Button -> BUTTON_TYPE
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is TextViewHolder -> holder.bind(dataList[position] as TypeDataModel.Text)
            is ButtonViewHolder -> holder.bind(dataList[position] as TypeDataModel.Button)
            is ImageViewHolder -> holder.bind(dataList[position] as TypeDataModel.Image)
        }
    }

    class TextViewHolder(private val binding: ItemTextBinding): ViewHolder(binding.root){
        fun bind(data: TypeDataModel.Text){
            binding.labelTextItem.text = data.text
        }
    }

    class ImageViewHolder(private val binding: ItemImageBinding): ViewHolder(binding.root){
        fun bind(data: TypeDataModel.Image){
            binding.imageItemView.setImageResource(data.id)
        }
    }

    class ButtonViewHolder(private val binding: ItemButtonBinding): ViewHolder(binding.root){
        fun bind(data: TypeDataModel.Button){
            binding.buttonItem.text = data.buttonText
        }
    }


    companion object{
        private const val TEXT_TYPE = 0
        private const val IMAGE_TYPE = 1
        private const val BUTTON_TYPE = 2
    }

}