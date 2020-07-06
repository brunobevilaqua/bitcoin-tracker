package com.example.bitcoin_tracker.user.login

import com.example.bitcoin_tracker.shared.config.AppDatabase
import com.example.bitcoin_tracker.shared.exception.InvalidUserLoginException
import com.example.bitcoin_tracker.user.User
import com.example.bitcoin_tracker.user.UserDao

class LoginPresenter : LoginContract.Presenter {
    private var dao: UserDao? = null

    constructor(database: AppDatabase) {
        this.dao = database.userDao()
    }

    @Throws(InvalidUserLoginException::class)
    override fun login(userEmail: String, userPassword: String): User {
        val user = dao?.getUserByEmailAndPassword(userEmail, userPassword)
        if (user != null) return user
        else throw InvalidUserLoginException()
    }

}