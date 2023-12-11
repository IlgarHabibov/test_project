package com.example.atlandroidexamples.lessons.lesson26

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentAlbumsBinding


class AlbumsFragment : Fragment() {

    private lateinit var binding: FragmentAlbumsBinding
    private val viewModel by viewModels<AlbumsViewModel>()
    private val adapter = AlbumsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.albumsRecyclerView.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner){state ->


            when(state){
                is AlbumsState.Success -> {
                    binding.albumsProgress.isVisible = false
                    state.albumsList?.let { adapter.updateData(it) }
                }
                is AlbumsState.Error ->{
                    binding.albumsProgress.isVisible = false
                    Toast.makeText(requireContext(), "${state.message}", Toast.LENGTH_SHORT).show()
                }
                is AlbumsState.Loading ->binding.albumsProgress.isVisible = true
            }

        }

        binding.loadButton.setOnClickListener {
            viewModel.getAlbums()
        }
    }

}