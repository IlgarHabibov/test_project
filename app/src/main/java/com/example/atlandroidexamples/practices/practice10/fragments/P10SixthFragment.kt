package com.example.atlandroidexamples.practices.practice10.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.atlandroidexamples.databinding.FragmentP10SixthBinding
import com.example.atlandroidexamples.db.MyDB
import com.example.atlandroidexamples.practices.practice10.viewmodel.NoteViewModel
import com.example.atlandroidexamples.practices.practice10.viewmodel.NoteViewModelFactory

class P10SixthFragment : Fragment() {

    private lateinit var binding: FragmentP10SixthBinding


    private val factory = NoteViewModelFactory(MyDB.appDatabase?.getPersonDAO())
    private val viewModel: NoteViewModel = factory.create(NoteViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentP10SixthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.allUsers?.observe(viewLifecycleOwner){
            val userId = it.map { it.id }
            binding.title.text = userId.toString()
        }
        binding.nextButton.setOnClickListener {
            viewModel.insert()
        }

        binding.backButton.setOnClickListener {
            viewModel.getUsers()
        }
    }

}