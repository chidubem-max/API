package com.chidubem.api.ui.steps

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chidubem.api.R
import com.chidubem.api.model.Recipe

class StepAdapter (private var stepList: List<Recipe.Step>): RecyclerView.Adapter<StepAdapter.StepViewHolder>(){

    inner class StepViewHolder(inflater:LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(
        inflater.inflate(R.layout.step_item,parent,false)) {
        private var  stepsName: TextView? = null


        init {
            stepsName = itemView.findViewById(R.id.steps_name_tv)
        }

        fun bind(step: Recipe.Step) {
            stepsName?.text = step.description
        }
    }

    fun updateList(list: List<Recipe.Step>) {
        stepList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StepViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val step: Recipe.Step = stepList[position]
        holder.bind(step)
    }

    override fun getItemCount(): Int = stepList.size


}