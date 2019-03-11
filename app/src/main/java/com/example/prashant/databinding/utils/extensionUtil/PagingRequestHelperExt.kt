package com.example.prashant.databinding.utils.extensionUtil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.prashant.databinding.utils.remoteUtils.Status

fun PagingRequestHelper.createStatusLiveData(): LiveData<Status> {
    val liveData = MutableLiveData<Status>()
    addListener { report ->
        when {
            report.hasRunning() -> liveData.postValue(Status.LOADING)
            report.hasError() -> liveData.postValue(Status.ERROR)
            else -> liveData.postValue(Status.SUCCESS)
        }
    }

    return liveData
}
