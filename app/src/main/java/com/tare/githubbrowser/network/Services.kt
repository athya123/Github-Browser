package com.tare.githubbrowser.network

import com.tare.githubbrowser.pojo.response.ResponseGetBranches
import com.tare.githubbrowser.pojo.response.ResponseGetCommits
import com.tare.githubbrowser.pojo.response.ResponseGetOpenIssues
import com.tare.githubbrowser.pojo.response.ResponseGetRepo
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Services {

    @GET("{owner}/{repo}")
    fun getRepo(
        @Path("owner") owner: String,
        @Path("repo") repoName: String
    ): Observable<ResponseGetRepo>

    @GET("{owner}/{repo}/branches")
    fun getRepoBranches(
        @Path("owner") owner: String,
        @Path("repo") repoName: String,
    ): Observable<ResponseGetBranches>

    @GET("{owner}/{repo}/issues?state=open")
    fun getOpenIssues(
        @Path("owner") owner: String,
        @Path("repo") repoName: String,
    ): Observable<ResponseGetOpenIssues>

    @GET("{owner}/{repo}/commits")
    fun getCommitsInBranch(
        @Path("owner") owner: String,
        @Path("repo") repoName: String,
        @Query("sha") sha: String
    ): Observable<ResponseGetCommits>
}