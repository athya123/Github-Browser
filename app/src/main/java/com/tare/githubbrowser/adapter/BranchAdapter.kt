package com.tare.githubbrowser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tare.githubbrowser.R
import com.tare.githubbrowser.databinding.ItemBranchBinding
import com.tare.githubbrowser.pojo.entities.ResponseGetBranchesItem
import com.tare.githubbrowser.ui.detail.branches.BranchFragment
import com.tare.githubbrowser.utils.DiffUtilBranch

class BranchAdapter(private val branchFragment: BranchFragment) :
    RecyclerView.Adapter<BranchAdapter.ViewHolder>() {
    private var itemList = listOf<ResponseGetBranchesItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemBranchBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_branch, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun submitList(list: List<ResponseGetBranchesItem>?){
        val old = itemList
        itemList = list ?: listOf()
        DiffUtil.calculateDiff(DiffUtilBranch(old,itemList)).dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemBranchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentBranch: ResponseGetBranchesItem) {
            binding.item = currentBranch
            binding.baseView = branchFragment
            binding.executePendingBindings()
        }
    }
}