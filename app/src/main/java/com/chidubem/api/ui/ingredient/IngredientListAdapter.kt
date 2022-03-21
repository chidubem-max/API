package com.chidubem.api.ui.ingredient

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chidubem.api.R
import com.chidubem.api.model.Recipe

class IngredientListAdapter (private var ingredientList: List<Recipe.Ingredient>): RecyclerView.Adapter<IngredientListAdapter.IngredientViewHolder>(){

    inner class IngredientViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(
        inflater.inflate(R.layout.ingredients_item,parent,false)) {
        private var ingredientsName: TextView? = null


        init {
            ingredientsName = itemView.findViewById(R.id.ingredients_name_tv)
        }

        fun bind(ingredient: Recipe.Ingredient){
            ingredientsName?.text = ingredient.ingredient

        }
    }

    fun updateList(list: List<Recipe.Ingredient>) {
        ingredientList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return IngredientViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient: Recipe.Ingredient = ingredientList[position]
        holder.bind(ingredient)
    }

    override fun getItemCount(): Int = ingredientList.size

}