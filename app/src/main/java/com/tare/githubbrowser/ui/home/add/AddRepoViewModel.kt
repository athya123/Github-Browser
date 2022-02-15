package com.tare.githubbrowser.ui.home.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tare.githubbrowser.ui.home.HomeRepository
import com.tare.githubbrowser.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRepoViewModel
@Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel(){

    val fetchRepoFromNetwork = homeRepository.responseGetRepo as MutableLiveData<Response>
    val repoToDB = homeRepository.addRepoToDB

    fun fetchRepoFromNetwork(owner: String, repoName: String){
        homeRepository.fetchRepoFromNetwork(owner, repoName)
    }

    fun addRepoToDB(repoName: String, repoUrl: String,description: String?,owner: String){
        homeRepository.addRepoToDB(repoUrl,repoName,description,owner)
    }

}