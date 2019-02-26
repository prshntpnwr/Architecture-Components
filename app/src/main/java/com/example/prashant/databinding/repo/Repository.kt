package com.example.prashant.databinding.repo

import androidx.lifecycle.LiveData
import com.example.prashant.databinding.data.Contact
import com.example.prashant.databinding.data.ContactDao
import com.example.prashant.databinding.remote.Webservice
import com.example.prashant.databinding.utils.AppExecutors
import javax.inject.Inject

class Repository @Inject constructor(
        val webservice: Webservice,
        val contactDao: ContactDao,
        val executor: AppExecutors) {

    fun get(): LiveData<List<Contact>> {
        refreshTask()
        return contactDao.loadAll()
    }

    private fun refreshTask() {
        // running in a background thread
        // check if data was fetched recently, otherwise call web server and fetch results
        // refresh the data
        // TODO check for error etc.
        // Update the database.The LiveData will automatically refresh so
        // we don't need to do anything else here besides updating the database

        executor.diskIO().execute {
            var i = 0
            do {
                contactDao.save(Contact((i + 1), "Name",
                        "111-222-3333", "a@b.com", "random"))
                i++
            } while (i < 10)
        }
    }
}
