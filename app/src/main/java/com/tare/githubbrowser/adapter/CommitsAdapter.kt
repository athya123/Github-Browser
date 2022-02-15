package com.tare.githubbrowser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tare.githubbrowser.R
import com.tare.githubbrowser.databinding.ItemCommitBinding
import com.tare.githubbrowser.pojo.response.ResponseGetCommits
import com.tare.githubbrowser.utils.DiffUtilCommit

class CommitsAdapter : RecyclerView.Adapter<CommitsAdapter.ViewHolder>() {
    private var itemList: List<ResponseGetCommits.ResponseGetCommitsItems> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCommitBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_commit, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun submitList(list: List<ResponseGetCommits.ResponseGetCommitsItems>?) {
        val old = itemList
        itemList = list ?: listOf()
        DiffUtil.calculateDiff(DiffUtilCommit(old,itemList)).dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemCommitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: ResponseGetCommits.ResponseGetCommitsItems) {
            binding.item = currentItem
            binding.executePendingBindings()
        }
    }
}