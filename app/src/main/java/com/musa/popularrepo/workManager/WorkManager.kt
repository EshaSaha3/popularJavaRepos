package com.musa.popularrepo.workManager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.musa.popularrepo.application.MyApplication
import com.musa.popularrepo.repository.RepoRepository
import retrofit2.HttpException
import javax.inject.Inject

class RefreshDataWork(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {
    @Inject
    lateinit var repository: RepoRepository

    companion object{
        const val WORK_NAME = "RefreshDataWork"
    }

    init {
        (context as MyApplication).applicationComponent.inject(this)
    }

    override suspend fun doWork(): Payload {
        return try {
            repository.refreshRepo()
            Payload(Result.SUCCESS)
        } catch (e: HttpException) {
            Payload(Result.RETRY)
        }

    }

}