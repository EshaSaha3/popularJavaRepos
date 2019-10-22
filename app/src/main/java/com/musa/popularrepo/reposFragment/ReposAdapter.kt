package com.musa.popularrepo.reposFragment

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.musa.popularrepo.model.DomainModel

import android.view.LayoutInflater
import android.view.ViewGroup
import com.musa.popularrepo.databinding.ListItemRepoBinding

class ReposAdapter : ListAdapter<DomainModel, ReposAdapter.ReposViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ReposViewHolder private constructor(private val binding: ListItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DomainModel) {
            binding.domainModel = data
        }

        companion object {
            fun from(parent: ViewGroup): ReposViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemRepoBinding.inflate(layoutInflater,parent,false)
                return ReposViewHolder(binding)
            }
        }


    }

    class DiffCallBack : DiffUtil.ItemCallback<DomainModel>() {
        override fun areItemsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
            return oldItem.id== oldItem.id
        }

        override fun areContentsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
            return oldItem == newItem
        }
    }

}