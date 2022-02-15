package com.tare.githubbrowser.utils

import androidx.recyclerview.widget.DiffUtil
import com.tare.githubbrowser.pojo.entities.Repository
import com.tare.githubbrowser.pojo.entities.ResponseGetBranchesItem
import com.tare.githubbrowser.pojo.entities.ResponseGetOpenIssuesItem
import com.tare.githubbrowser.pojo.response.ResponseGetCommits

class DiffUtilHome(private val oldList: List<Repository>, private val newList: List<Repository>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}

class DiffUtilBranch(
    private val oldList: List<ResponseGetBranchesItem>,
    private val newList: List<ResponseGetBranchesItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}

class DiffUtilCommit(
    private val oldList: List<ResponseGetCommits.ResponseGetCommitsItems>,
    private val newList: List<ResponseGetCommits.ResponseGetCommitsItems>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].sha == newList[newItemPosition].sha
    }

}

class DiffUtilIssues(
    private val oldList: List<ResponseGetOpenIssuesItem>,
    private val newList: List<ResponseGetOpenIssuesItem>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

}