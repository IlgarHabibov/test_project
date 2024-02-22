package com.example.atlandroidexamples.practices.practice21.note_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentNoteDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailsBinding
    private val viewModel by viewModels<NoteDetailsVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val id = NoteDetailsFragmentArgs.fromBundle(it).id
            viewModel.setNoteId(id)
        }

        viewModel.state.observe(viewLifecycleOwner){state ->
            binding.title.text = state.title
            binding.note.text = state.description
        }

        viewModel.getNoteDetails()
    }

}