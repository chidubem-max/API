package com.chidubem.api.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.chidubem.api.R
import com.chidubem.api.databinding.FragmentRecipeBinding
import com.chidubem.api.model.Recipe

class RecipeFragment : Fragment() {

    private lateinit var binding : FragmentRecipeBinding

   private val recipeViewModel by lazy { ViewModelProvider(this)[RecipeViewModel::class.java] }

   private val  adapter: RecipeListAdapter by lazy {
       RecipeListAdapter(onRecipeSelected, arrayListOf())
   }

    private val onRecipeSelected by lazy {
        object : RecipeItemClicklistener{
            override fun invoke(chow : Recipe) {
                var action = RecipeFragmentDirections.actionRecipeFragmentsToIngredientFragment(chow)
                findNavController().navigate(action)
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRecipeBinding.inflate(layoutInflater)
        val bind = binding.root

        recipeViewModel.recipes.observe(viewLifecycleOwner,  { newList ->
            adapter.updateList(newList)
            binding.recipeRv.adapter = adapter

        })

        return bind
    }



}