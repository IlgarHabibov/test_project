package com.example.atlandroidexamples.practices.practice21.notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentNotesBinding
import com.example.atlandroidexamples.lessons.lesson27.collectFlow
import com.example.atlandroidexamples.utils.SpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private val viewModel by viewModels<NotesMVIVM>()
    private val adapter by lazy { NoteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.notesList.adapter = adapter

        binding.notesList.addItemDecoration(
            SpaceItemDecoration(
                resources.getDimensionPixelSize(R.dimen.dimen_6dp)
            )
        )

        adapter.setItemClickListener {
            findNavController().navigate(NotesFragmentDirections.actionToNoteDetailsFragment(it.id))
        }



        binding.addNote.setOnClickListener {
//            findNavController().navigate(NotesFragmentDirections.actionToCreateNoteFragment())
            viewModel.obtainEvent(NotesMVIVM.Event.CheckButton)
        }


        viewModel.state.observe(viewLifecycleOwner) { data ->
            onStateChange(data)
        }


        viewModel.obtainEvent(NotesMVIVM.Event.GetNotes)

    }


    private fun onStateChange(state: NotesMVIVM.UiState?) {
        when (state) {
            is NotesMVIVM.UiState.Loading -> {
                binding.loading.isVisible = state.isLoading
            }

            is NotesMVIVM.UiState.Error -> {
                Toast.makeText(requireContext(), "error: ${state.error}", Toast.LENGTH_SHORT).show()
            }

            is NotesMVIVM.UiState.Data -> {
                adapter.submitList(state.data)
            }

            is NotesMVIVM.UiState.Navigate -> {
                findNavController().navigate(NotesFragmentDirections.actionToCreateNoteFragment())
            }

            else -> {

            }
        }
    }

//    private fun onStateChange(state: NotesVM.UiState?) {
//        Log.d("asdasdasdasdasd", "onStateChange: $state")
//        when (state) {
//            is NotesVM.UiState.Loading -> {
//                binding.loading.isVisible = state.isLoading
//            }
//
//            is NotesVM.UiState.Error -> {
//                Toast.makeText(requireContext(), "error: ${state.error}", Toast.LENGTH_SHORT).show()
//            }
//
//            is NotesVM.UiState.Data -> {
//                adapter.submitList(state.data)
//            }
//
//            else -> {
//
//            }
//        }
//    }


//    private fun onStateChange(state: NotesVM.State) {
//        state.data?.let {
//            adapter.submitList(it)
//        }
//        binding.loading.isVisible = state.isLoading
//
//        state.error?.let {
//            Toast.makeText(requireContext(), "error: $it", Toast.LENGTH_SHORT).show()
//        }
//
//    }

}