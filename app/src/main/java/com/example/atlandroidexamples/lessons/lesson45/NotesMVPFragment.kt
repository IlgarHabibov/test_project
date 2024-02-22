package com.example.atlandroidexamples.lessons.lesson45

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
import com.example.atlandroidexamples.practices.practice21.notes.NoteAdapter
import com.example.atlandroidexamples.practices.practice21.notes.NoteModel
import com.example.atlandroidexamples.utils.SpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesMVPFragment : Fragment(), NotesContractor.View {

    private lateinit var binding: FragmentNotesBinding
    private val adapter by lazy { NoteAdapter() }

    private var presenter: NotesContractor.Presenter?  = NotesPresenter(this)

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

        presenter?.getNotes()

    }

    override fun showLoading(isLoading: Boolean) {
        binding.loading.isVisible = isLoading
    }

    override fun onSuccess(notes: List<NoteModel>) {
        adapter.submitList(notes)
    }

    override fun onFail(errorMessage: String?) {
        Toast.makeText(requireContext(), "error: $errorMessage", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }

}