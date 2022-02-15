package com.tare.githubbrowser.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tare.githubbrowser.database.RepoDao
import com.tare.githubbrowser.network.Services
import com.tare.githubbrowser.pojo.entities.Repository
import com.tare.githubbrowser.pojo.response.ResponseGetRepo
import com.tare.githubbrowser.utils.Response
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeRepository
@Inject constructor(
    private val services: Services,
    private val repoDao: RepoDao
) {
    private val _repoList = MutableLiveData<List<Repository>>()
    val repoList: LiveData<List<Repository>>
        get() = _repoList

    val addRepoToDB = MutableLiveData<Boolean>()

    private val _responseGetRepo = MutableLiveData<Response>()
    val responseGetRepo: LiveData<Response>
        get() = _responseGetRepo

    fun fetchRepoList() {
        repoDao.getAllRepo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _repoList.postValue(it)
            }
    }

    fun fetchRepoFromNetwork(owner: String, repoName: String) {
        services.getRepo(owner, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _responseGetRepo.postValue(Response.Success(it))
            }, {
                _responseGetRepo.postValue(Response.Error(it.message!!))
            })
    }

    fun addRepoToDB(url: String, repoName: String, description: String?,owner: String) {
        repoDao.insert(Repository(0, repoName, description, url,owner))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("ISCALLED", "$it")
//                if(it != 0.toLong()){
//                    addRepoToDB.postValue(true)
//                }else{
                    addRepoToDB.postValue(true)

            },{

                Log.d("ISCALLED", "$it")
                addRepoToDB.postValue(false)
            })
    }

}