package com.tare.githubbrowser.ui.detail.branches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tare.githubbrowser.R
import com.tare.githubbrowser.adapter.BranchAdapter
import com.tare.githubbrowser.databinding.FragmentBranchBinding
import com.tare.githubbrowser.pojo.entities.ResponseGetBranchesItem
import com.tare.githubbrowser.ui.detail.commits.CommitsFragment
import com.tare.githubbrowser.ui.detail.DetailActivity
import com.tare.githubbrowser.ui.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BranchFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel
    private val branchAdapter = BranchAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailViewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]
        val binding: FragmentBranchBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_branch, container, false)
        subscribeObservers(binding.RvBranch)
        return binding.root
    }

    private fun subscribeObservers(recyclerView: RecyclerView) {
        recyclerView.adapter = branchAdapter
        detailViewModel.branches.observe(viewLifecycleOwner) {
            branchAdapter.submitList(it)
        }
    }

    fun onBranchClick(item: ResponseGetBranchesItem) {
        (requireActivity() as DetailActivity).replaceFragment(CommitsFragment.newInstance(
            item.commit.sha,
            detailViewModel.dbRepo.value?.name,
            detailViewModel.dbRepo.value?.owner,
            item.name
        ))
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BranchFragment()
    }
}