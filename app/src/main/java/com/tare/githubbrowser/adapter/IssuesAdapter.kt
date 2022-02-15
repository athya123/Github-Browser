package com.tare.githubbrowser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tare.githubbrowser.R
import com.tare.githubbrowser.databinding.ItemIssuesBinding
import com.tare.githubbrowser.pojo.entities.ResponseGetOpenIssuesItem
import com.tare.githubbrowser.utils.DiffUtilIssues

class IssuesAdapter : RecyclerView.Adapter<IssuesAdapter.ViewHolder>() {
    private var itemList: List<ResponseGetOpenIssuesItem> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemIssuesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_issues, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun submitList(list: List<ResponseGetOpenIssuesItem>?) {
        val old = itemList
        itemList = list ?: listOf()
        DiffUtil.calculateDiff(DiffUtilIssues(old,itemList)).dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemIssuesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: ResponseGetOpenIssuesItem) {
            binding.item = currentItem
            binding.executePendingBindings()
        }
    }
}