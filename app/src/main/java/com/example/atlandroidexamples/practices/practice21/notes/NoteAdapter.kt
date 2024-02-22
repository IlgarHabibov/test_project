package com.example.atlandroidexamples.practices.practice21.notes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.atlandroidexamples.databinding.LayoutNoteItemBinding

class NoteAdapter: ListAdapter<NoteModel, NoteAdapter.NoteViewHolder>(DIFF_UTIL) {

    private var onItemClick: ((note: NoteModel) -> Unit)? = null

    fun setItemClickListener(onItemClick: (note: NoteModel) -> Unit){
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutNoteItemBinding.inflate(inflater, parent, false)
        return NoteViewHolder((binding))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(currentList[position], onItemClick)
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

    companion object{
        val DIFF_UTIL = object : DiffUtil.ItemCallback<NoteModel>(){
            override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.title == newItem.title &&
                        oldItem.description == newItem.description
            }

        }
    }
}