package com.example.atlandroidexamples.lessons.lesson24.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.atlandroidexamples.databinding.FragmentL24Binding
import com.example.atlandroidexamples.lessons.lesson24.SimpleListViewModel
import com.example.atlandroidexamples.db.entities.TextEntity
import com.example.atlandroidexamples.practices.practice11.OnNoteClickListener


class L24Fragment : Fragment() {


    private lateinit var binding: FragmentL24Binding
    private val adapter = SimpleListAdapter()

    private val viewModel: SimpleListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentL24Binding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textList.adapter = adapter

//        viewModel.data?.observe(viewLifecycleOwner){
//            adapter.updateData(it)
//        }

        viewModel.entityData.observe(viewLifecycleOwner){

            binding.inputEditText.setText(it.text)
        }

        adapter.setOnClickListener(object : OnNoteClickListener {
            override fun onItemDeleteClick(textEntity: TextEntity) {
                onDeleteClick(textEntity)
            }

            override fun onItemClick(textEntity: TextEntity) {
                viewModel.setTextEntityFromList(textEntity)
            }
        })

        binding.saveButton.setOnClickListener {
            if (binding.inputEditText.text.isNullOrEmpty().not()){
                val text = binding.inputEditText.text.toString()
                binding.inputEditText.setText("")
                viewModel.addNewText(text)

            }
        }

    }

    fun onDeleteClick(textEntity: TextEntity){
        AlertDialog.Builder(requireContext())
            .setTitle("Silmeye eminsiniz?")
            .setPositiveButton( "Beli"
            ) { p0, p1 ->
                viewModel.delete(textEntity)
            }
            .setNegativeButton( "Legv et"
            ) { p0, p1 ->
                Toast.makeText(requireContext(), "Legv edildi", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

}