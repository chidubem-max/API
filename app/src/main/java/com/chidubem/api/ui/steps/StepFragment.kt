package com.chidubem.api.ui.steps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chidubem.api.R
import com.chidubem.api.databinding.FragmentStepBinding


class StepFragment : Fragment() {

    private lateinit var binding: FragmentStepBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStepBinding.inflate(layoutInflater)


        return binding.root
    }

}