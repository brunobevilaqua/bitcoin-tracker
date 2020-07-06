package com.example.bitcoin_tracker.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "USER_ID") val userId: Long = 0,

    @ColumnInfo(name = "USER_FIRST_NAME")
    val userFirstName: String,

    @ColumnInfo(name = "USER_LAST_NAME")
    val userLastName: String,

    @ColumnInfo(name = "USER_PASSWORD")
    val userPassword: String,

    @ColumnInfo(name = "USER_EMAIL")
    val userEmail: String
)