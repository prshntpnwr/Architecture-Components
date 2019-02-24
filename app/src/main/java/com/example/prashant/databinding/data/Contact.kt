package com.example.prashant.databinding.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
        @PrimaryKey(autoGenerate = false)
        var id: Int = 0,
        var name: String? = null,
        var mobile: String? = null,
        var email: String? = null,
        var address: String? = null
)
