package com.tare.githubbrowser.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel(){
    init {
        homeRepository.fetchRepoList()
    }
    val repoList = homeRepository.repoList
}