package com.example.atlandroidexamples.lessons.lesson41

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.FragmentStep1Binding


class Step1Fragment : Fragment() {

    private lateinit var binding: FragmentStep1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStep1Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.motionLayout.setTransitionListener(
            object : MotionLayout.TransitionListener {

                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int
                ) {

                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {

                }

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                    if (currentId == R.id.start) {
                        binding.progress.text = "in left"
                    } else {
                        binding.progress.text = "in right"
                    }
                    Toast.makeText(requireContext(), "complete", Toast.LENGTH_SHORT).show()

                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float
                ) {
                }

            }
        )


        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in)
            .setExitAnim(R.anim.slide_out)
            .setPopEnterAnim(R.anim.pop_in)
            .setPopExitAnim(R.anim.pop_out)
            .build()

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(
                Step1FragmentDirections.actionStep1FragmentToStep2Fragment(),
                navOptions
            )
//            findNavController().navigate(
//                Step1FragmentDirections.actionStep1FragmentToStep2Fragment()
//            )
        }


        Log.d("ASDASDASdasd", "onViewCreated: ")

//        parentFragmentManager.beginTransaction()
//            .setCustomAnimations(
//                R.anim.slide_in,
//                R.anim.slide_out,
//                R.anim.pop_in,
//                R.anim.pop_out,
//            )
//            .replace()

    }


}