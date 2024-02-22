package com.example.atlandroidexamples.practices.practice21.notes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.LayoutNoteItemBinding
import okhttp3.internal.notify

class NoteAdapterOld: RecyclerView.Adapter<NoteAdapterOld.NoteViewHolder>() {

    private val dataList = mutableListOf<NoteModel>()


    fun setData(newData: List<NoteModel>){
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }

    private var onItemClick: ((note: NoteModel) -> Unit)? = null

    fun onItemClickListener(onItemClick: (note: NoteModel) -> Unit){
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutNoteItemBinding.inflate(inflater, parent, false)
        return NoteViewHolder((binding))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(dataList[position], onItemClick)
    }



    class NoteViewHolder(
        private val binding: LayoutNoteItemBinding
    ): ViewHolder(binding.root){

        fun bind(note: NoteModel, onItemClick: ((note: NoteModel) -> Unit)?){
            binding.title.text = note.title
            binding.description.text = note.description
            binding.root.setOnClickListener {
                onItemClick?.invoke(note)
            }
        }
    }


}