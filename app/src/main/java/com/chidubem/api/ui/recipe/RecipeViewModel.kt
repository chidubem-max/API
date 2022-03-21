package com.chidubem.api.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chidubem.api.model.Recipe
import com.chidubem.api.network.ApiService
import com.chidubem.api.network.RecipeApi
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {

    private val _recipes = MutableLiveData<ArrayList<Recipe>>()
    val recipes: LiveData<ArrayList<Recipe>> get() = _recipes

    private val _ingredients = MutableLiveData<List<Recipe.Ingredient>>()
    val ingredients: LiveData<List<Recipe.Ingredient>> get() = _ingredients

    private val _steps = MutableLiveData<List<Recipe.Step>>()
    val steps: LiveData<List<Recipe.Step>> get() = _steps


    init {
        getRecipeList()
        getIngredientsList()
        getStepsList()
    }

    private fun getStepsList() {
        viewModelScope.launch {
            val listStep = RecipeApi.retrofitService.getSteps()
        }
    }

    private fun getRecipeList() {
        viewModelScope.launch {
            val listRecipe = RecipeApi.retrofitService.getRecipe()
            _recipes.value = listRecipe
        }
    }

    private fun getIngredientsList() {
        viewModelScope.launch {
            val listIngredient = RecipeApi.retrofitService.getIngredient()
            _ingredients.value = listIngredient
        }
    }



}