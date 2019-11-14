package com.musa.popularrepo.reposFragment

import android.graphics.Color
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.musa.popularrepo.model.DomainModel

import android.view.LayoutInflater
import android.view.ViewGroup
import com.musa.popularrepo.databinding.ListItemRepoBinding

class ReposAdapter(private val listener: ReposListener) :
    ListAdapter<DomainModel, ReposAdapter.ReposViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    class ReposViewHolder private constructor(private val binding: ListItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DomainModel, listener: ReposListener) {
            binding.domainModel = data
            binding.clickListener = listener
        }

        companion object {
            fun from(parent: ViewGroup): ReposViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemRepoBinding.inflate(layoutInflater, parent, false)
                return ReposViewHolder(binding)
            }
        }


    }

    class DiffCallBack : DiffUtil.ItemCallback<DomainModel>() {
        override fun areItemsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
            return oldItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
            return oldItem == newItem
        }
    }

    class ReposListener(val clickListener: (domainModelId: Int) -> Unit) {
        fun onclick(domainModel: DomainModel) = clickListener(domainModel.id)
    }

}