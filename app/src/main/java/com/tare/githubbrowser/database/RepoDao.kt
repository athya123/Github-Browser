package com.tare.githubbrowser.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tare.githubbrowser.pojo.entities.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: Repository): Single<Long>

    @Query("SELECT * FROM Repository")
    fun getAllRepo(): Observable<List<Repository>>

    @Query("DELETE FROM Repository WHERE id= :repoId")
    fun deleteRepo(repoId: Int): Single<Int>

    @Query("SELECT * FROM Repository WHERE id= :repoId")
    fun getRepoById(repoId: Int): Single<Repository>
}