package com.chidubem.api.ui.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chidubem.api.R
import com.chidubem.api.model.Recipe

typealias RecipeItemClicklistener = (Recipe) -> Unit

class RecipeListAdapter (private val onClickListener: RecipeItemClicklistener, private var recipeList: List<Recipe>):
    RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>(){

    inner class RecipeViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(
        inflater.inflate(R.layout.recipe_item,parent,false)), View.OnClickListener {
        private var recipeName: TextView? = null


        init {
            recipeName = itemView.findViewById(R.id.recipe_name_tv)
            itemView.setOnClickListener(this)
        }

        fun bind(recipe: Recipe){
            recipeName?.text = recipe.name
        }

        override fun onClick(v: View?) {
            var recipe = recipeList[adapterPosition]
            onClickListener.invoke(recipe)
        }
    }

    fun updateList(list: ArrayList<Recipe>) {
        recipeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecipeViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe: Recipe = recipeList[position]
        holder.bind(recipe)

    }

    override fun getItemCount(): Int = recipeList.size

}

