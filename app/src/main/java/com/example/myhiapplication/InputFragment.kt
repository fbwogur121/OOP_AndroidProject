package com.example.myhiapplication

import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhiapplication.databinding.FragmentInputBinding


class InputFragment() : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInputBinding.inflate(inflater, container, false)
        arguments?.let{
            binding.edtText.setText(arguments?.getString("text"))
        }
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance(str: String? = null) =
            InputFragment().apply{
                arguments = Bundle().apply{
                    str?.let{
                        putString("text", it)
                    }
                }
            }


        /*
        @JvmStatic
        fun newInstance(str: String) =
            InputFragment().apply {
                arguments = Bundle().apply {
                    putString("text", str)
                }
            }
        */
    }
}