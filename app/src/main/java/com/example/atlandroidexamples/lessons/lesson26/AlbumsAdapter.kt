package com.example.atlandroidexamples.lessons.lesson26

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.example.atlandroidexamples.databinding.ItemAlbumsBinding
import com.example.atlandroidexamples.network.model.AlbumModel

class AlbumsAdapter: RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    private var dataList = mutableListOf<AlbumModel>()

    fun updateData(newDataList: List<AlbumModel>){
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumsBinding.inflate(inflater, parent, false)
        return AlbumsViewHolder((binding))
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.bind(dataList[position])
    }



    class AlbumsViewHolder(private val binding: ItemAlbumsBinding): ViewHolder(binding.root){
        fun bind(data: AlbumModel){
            binding.labelAlbumName.text = data.title
            binding.imageAlbum.load(data.thumbnailUrl){
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }
}




//fun <T: ViewBinding> ViewGroup.bindView(attachRoot: Boolean = false): T{
//
//}