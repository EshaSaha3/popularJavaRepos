package com.musa.popularrepo.networkUtils

import retrofit2.Response


fun <T : Any> getApiResult(response: Response<T>): Result<T> {
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
            return Result.Success(body)
        }
    }
    return Result.Error("${response.code()}", response.message())
}