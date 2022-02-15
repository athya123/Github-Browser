package com.tare.githubbrowser.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tare.githubbrowser.database.RepoDao
import com.tare.githubbrowser.network.Services
import com.tare.githubbrowser.pojo.entities.Repository
import com.tare.githubbrowser.pojo.entities.ResponseGetBranchesItem
import com.tare.githubbrowser.pojo.entities.ResponseGetOpenIssuesItem
import com.tare.githubbrowser.pojo.response.ResponseGetBranches
import com.tare.githubbrowser.pojo.response.ResponseGetCommits
import com.tare.githubbrowser.pojo.response.ResponseGetOpenIssues
import com.tare.githubbrowser.pojo.response.ResponseGetRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailRepository
@Inject constructor(
    private val services: Services,
    private val repoDao: RepoDao
){

    private val _getRepoById = MutableLiveData<Repository?>()
    val getRepoById: LiveData<Repository?>
        get() = _getRepoById

    private val _branches = MutableLiveData<List<ResponseGetBranchesItem>?>()
    val branches: LiveData<List<ResponseGetBranchesItem>?>
        get() = _branches

    private val _openIssues = MutableLiveData<List<ResponseGetOpenIssuesItem>?>()
    val openIssues: LiveData<List<ResponseGetOpenIssuesItem>?>
        get() = _openIssues

    private val _commits = MutableLiveData<List<ResponseGetCommits.ResponseGetCommitsItems>?>()
    val commits: LiveData<List<ResponseGetCommits.ResponseGetCommitsItems>?>
        get() = _commits

    val deleteRepo = MutableLiveData<Boolean>()

    fun fetchRepoById(repoId: Int){
        repoDao.getRepoById(repoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _getRepoById.postValue(it)
            },{
                _getRepoById.postValue(null)
            })
    }

    fun deleteRepo(repoId: Int){
        repoDao.deleteRepo(repoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it != 0)
                    deleteRepo.postValue(true)
            },{
                deleteRepo.postValue(false)
            })
    }

    fun fetchRepoBranches(owner: String, repoName: String){
        services.getRepoBranches(owner, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _branches.postValue(it)
            },{
                _branches.postValue(null)
            })
    }

    fun fetchOpenIssues(owner: String,repoName: String){
        services.getOpenIssues(owner, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _openIssues.postValue(it)
            },{
                _openIssues.postValue(null)
            })
    }

    fun fetchCommitsInBranch(owner: String, name: String, sha: String){
        services.getCommitsInBranch(owner,name,sha)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _commits.postValue(it)
            },{
                _commits.postValue(null)
            })
    }


}