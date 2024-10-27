package com.example.myhiapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhiapplication.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentResultBinding.inflate(inflater, container, false).apply {
            arguments?.let {
                txtResult.text = it.getInt("kor_count").toString()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(count: Int) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt("kor_count", count)
                }
            }
    }
}