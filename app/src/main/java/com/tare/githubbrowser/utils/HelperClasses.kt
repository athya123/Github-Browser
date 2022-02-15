package com.tare.githubbrowser.utils

import com.tare.githubbrowser.pojo.response.ResponseGetRepo

sealed class Response {
    data class Success(val responseGetRepo: ResponseGetRepo) : Response()
    data class Error(val message: String) : Response()
    object Empty: Response()
}