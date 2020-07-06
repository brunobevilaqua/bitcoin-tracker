package com.example.bitcoin_tracker.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun findAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE USER_ID = :userId")
    fun getUserById(userId: Long): User

    @Insert
    fun createUser(user: User)

    @Query("SELECT * FROM user WHERE USER_EMAIL = :userEmail AND USER_PASSWORD = :userPassword")
    fun getUserByEmailAndPassword(userEmail: String, userPassword: String): User
}