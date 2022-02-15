package com.tare.githubbrowser.ui.detail.commits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tare.githubbrowser.R
import com.tare.githubbrowser.adapter.CommitsAdapter
import com.tare.githubbrowser.databinding.FragmentCommitsBinding
import com.tare.githubbrowser.ui.detail.DetailActivity
import com.tare.githubbrowser.ui.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val SHA = "SHA"
private const val NAME = "NAME"
private const val OWNER = "OWNER"
private const val BRANCH_NAME = "BRANCH"

@AndroidEntryPoint
class CommitsFragment : Fragment() {
    private var sha: String? = null
    private var repoName: String? = null
    private var owner: String? = null
    private var branchName: String? = null
    private val commitsAdapter = CommitsAdapter()
    private lateinit var detailViewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sha = it.getString(SHA)
            repoName = it.getString(NAME)
            owner = it.getString(OWNER)
            branchName = it.getString(BRANCH_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as DetailActivity).supportActionBar?.title = "Commits"
        branchName?.let { (requireActivity() as DetailActivity).supportActionBar?.subtitle = it }
        setHasOptionsMenu(true)
        detailViewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]
        val binding: FragmentCommitsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_commits, container, false
        )
        binding.apply {
            lifecycleOwner = this@CommitsFragment
        }
        detailViewModel.fetchRepoCommits(owner, repoName, sha)
        subscribeObservers(binding)
        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.delete_repo).isVisible = false
        menu.findItem(R.id.open_browser).isVisible = false
    }

    private fun subscribeObservers(binding: FragmentCommitsBinding) {
        binding.RvCommits.adapter = commitsAdapter
        detailViewModel.commits.observe(viewLifecycleOwner) {
            commitsAdapter.submitList(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(sha: String?, repoName: String?, owner: String?, branchName: String) =
            CommitsFragment().apply {
                arguments = Bundle().apply {
                    putString(SHA, sha)
                    putString(NAME, repoName)
                    putString(OWNER, owner)
                    putString(BRANCH_NAME, branchName)
                }
            }
    }
}