package com.example.prashant.databinding.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
        @PrimaryKey(autoGenerate = false)
        var id: Int = 0,
        var name: String? = null,
        var mobile: String? = null,
        var email: String? = null,
        var address: String? = null
)
