package com.example.bitcoin_tracker.user.register

import androidx.room.Transaction
import com.example.bitcoin_tracker.shared.config.AppDatabase
import com.example.bitcoin_tracker.user.User
import com.example.bitcoin_tracker.user.UserDao

class UserRegistrationPresenter : UserRegistrationContract.Presenter {
    private lateinit var dao: UserDao

    constructor(database: AppDatabase) {
        this.dao = database.userDao()
    }

    @Transaction
    override fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ) {
        val newUser = User(
            userFirstName = firstName,
            userLastName = lastName,
            userEmail = email,
            userPassword = password
        )
        return dao.createUser(newUser)
    }
}