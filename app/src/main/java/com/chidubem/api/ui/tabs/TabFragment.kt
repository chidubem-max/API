package com.chidubem.api.ui.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chidubem.api.R
import com.chidubem.api.databinding.FragmentTabBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.concurrent.fixedRateTimer

class TabFragment : Fragment() {


    private lateinit var binding: FragmentTabBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentTabBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        TabLayoutMediator(binding.tabLayout, binding.Pager) { tab, position ->
            tab.text = if(position == 0){
                "INGREDIENTS"
            }else{
                "STEPS"
            }
        }.attach()
    }


}