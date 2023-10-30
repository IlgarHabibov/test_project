package com.example.atlandroidexamples.lessons.lesson19

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentMyDialogBinding


class MyDialogFragment() : DialogFragment() {

    private lateinit var binding: FragmentMyDialogBinding


    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.closeButton.setOnClickListener {
            parentFragmentManager.setFragmentResult(
                MY_DIALOG_REQUEST_KEY,
                bundleOf(RESULT_KEY to CLOSE)
            )
            dismiss()
        }
        binding.nextButton.setOnClickListener {
            parentFragmentManager.setFragmentResult(
                MY_DIALOG_REQUEST_KEY,
                bundleOf(RESULT_KEY to NEXT)
            )
            dismiss()
        }
    }

    companion object {
        const val MY_DIALOG_REQUEST_KEY = "MY_DIALOG_REQUEST_KEY"
        const val NEXT = "NEXT"
        const val CLOSE = "CLOSE"
        const val RESULT_KEY = "RESULT_KEY"
    }

}