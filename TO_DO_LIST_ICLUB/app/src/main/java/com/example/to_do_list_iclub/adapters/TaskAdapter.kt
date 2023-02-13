package com.example.to_do_list_iclub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list_iclub.Models.Taskmodel
import com.example.to_do_list_iclub.databinding.CardViewDesignBinding

class TaskAdapter:ListAdapter<Taskmodel, TaskAdapter.MyViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CardViewDesignBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }

    class MyViewHolder(private val binding: CardViewDesignBinding) : RecyclerView.ViewHolder(binding.root){
        //connect with xml
        fun bind(task: Taskmodel){
            binding.task=task
        }

    }

    object DiffCallback:DiffUtil.ItemCallback<Taskmodel>() {
        override fun areItemsTheSame(oldItem: Taskmodel, newItem: Taskmodel): Boolean {
           return oldItem.text==newItem.text
        }

        override fun areContentsTheSame(oldItem: Taskmodel, newItem: Taskmodel): Boolean {
            return oldItem==newItem
        }

    }

}


