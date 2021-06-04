package com.kanyideveloper.chucknorrisjokesapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.chucknorrisjokesapi.databinding.JokesRowBinding

class JokesAdapter : ListAdapter<Jokes.Value, JokesAdapter.MyViewHolder>(DiffUtilCallback) {

    object DiffUtilCallback : DiffUtil.ItemCallback<Jokes.Value>(){
        override fun areItemsTheSame(oldItem: Jokes.Value, newItem: Jokes.Value): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Jokes.Value, newItem: Jokes.Value): Boolean {
           return oldItem.id == newItem.id
        }

    }


    inner class MyViewHolder(private val binding: JokesRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(joke: Jokes.Value?) {
            binding.textViewId.text = joke?.id.toString()
            binding.textViewJoke.text = joke?.joke
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(JokesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val joke = getItem(position)
        holder.bind(joke)
    }
}