package com.tare.githubbrowser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tare.githubbrowser.ui.home.HomeActivity
import com.tare.githubbrowser.R
import com.tare.githubbrowser.databinding.ItemHomeBinding
import com.tare.githubbrowser.pojo.entities.Repository
import com.tare.githubbrowser.utils.DiffUtilHome

class HomeAdapter(private val mainActivity: HomeActivity) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var itemList: List<Repository> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_home, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun submitList(list: List<Repository>) {
        val old = itemList
        itemList = list
        DiffUtil.calculateDiff(DiffUtilHome(old, itemList)).dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: Repository) {
            binding.item = currentItem
            binding.baseView = mainActivity
            binding.executePendingBindings()
        }
    }
}