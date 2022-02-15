package com.tare.githubbrowser.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tare.githubbrowser.ui.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {

    val dbRepo = detailRepository.getRepoById
    val branches = detailRepository.branches
    val openIssues = detailRepository.openIssues
    val commits = detailRepository.commits
    val deleteRepo = detailRepository.deleteRepo

    fun fetchRepoDB(repoId: Int) {
        detailRepository.fetchRepoById(repoId)
    }

    fun fetchDetailsForRepo(owner: String, repoName: String) {
        detailRepository.fetchRepoBranches(owner, repoName)
        detailRepository.fetchOpenIssues(owner, repoName)
    }

    fun fetchRepoCommits(owner: String?, repoName: String?, sha: String?) {
        owner?.let { own ->
            repoName?.let { name ->
                sha?.let { sh ->
                    detailRepository.fetchCommitsInBranch(own, name, sh)
                }
            }
        }
    }

    fun deleteRepo(repoId: Int){
        detailRepository.deleteRepo(repoId)
    }
}