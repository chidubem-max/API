package com.chidubem.api.ui.ingredient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.chidubem.api.databinding.FragmentIngredientBinding
import com.chidubem.api.model.Recipe
import com.chidubem.api.ui.recipe.RecipeViewModel


class IngredientFragment : Fragment() {

    private lateinit var binding: FragmentIngredientBinding

    val args: IngredientFragmentArgs by navArgs()

//    private val ingredientListAdapter: IngredientListAdapter by lazy {
//        IngredientListAdapter(arrayListOf())
//    }


    companion object {

        const val ARG_INGREDIENTS = "my.ingredients"


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var ingredientListAdapter = args.recipeSelected.ingredients?.let { IngredientListAdapter(it) }
        binding = FragmentIngredientBinding.inflate(layoutInflater)



        binding.ingredientsRv.adapter= ingredientListAdapter

        return binding.root
    }

}