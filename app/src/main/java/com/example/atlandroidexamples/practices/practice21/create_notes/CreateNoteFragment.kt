package com.example.atlandroidexamples.practices.practice21.create_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentCreateNoteBinding
import com.example.atlandroidexamples.lessons.lesson27.collectFlow
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding
    private val viewModel by viewModels<CreateNoteVM>()
//    val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()){
//
//    }
//    val cameraPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()){
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.save.setOnClickListener {
            checkFields(
                binding.titleInput.text.toString(),
                binding.descInput.text.toString()
            )
        }

        viewModel.state.observe(viewLifecycleOwner, ::onStateChange)
    }


    private fun checkFields(title: String?, noteText: String?){
        if (title.isNullOrEmpty()){
            Toast.makeText(requireContext(), "Title is empty", Toast.LENGTH_SHORT).show()
            return
        }

        if (noteText.isNullOrEmpty()){
            Toast.makeText(requireContext(), "Note is empty", Toast.LENGTH_SHORT).show()
            return
        }

        viewModel.createNewNote(title, noteText)

    }

    private fun onStateChange(isSuccess: Boolean) {
        if (isSuccess){
            findNavController().popBackStack()
        }
    }

}
