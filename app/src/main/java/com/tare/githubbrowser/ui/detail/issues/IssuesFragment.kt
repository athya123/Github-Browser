package com.tare.githubbrowser.ui.detail.issues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tare.githubbrowser.R
import com.tare.githubbrowser.adapter.IssuesAdapter
import com.tare.githubbrowser.databinding.FragmentIssuesBinding
import com.tare.githubbrowser.ui.detail.DetailViewModel

class IssuesFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel
    private val issuesAdapter = IssuesAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailViewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]
        val binding: FragmentIssuesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_issues, container, false)

        binding.lifecycleOwner = this
        subscribeObservers(binding)
        return binding.root
    }

    private fun subscribeObservers(binding: FragmentIssuesBinding) {
        binding.RvIssues.adapter = issuesAdapter
        detailViewModel.openIssues.observe(viewLifecycleOwner) {
            issuesAdapter.submitList(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = IssuesFragment()
    }
}