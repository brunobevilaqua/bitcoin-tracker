package com.example.bitcoin_tracker.user.login

import com.example.bitcoin_tracker.shared.exception.InvalidUserLoginException
import com.example.bitcoin_tracker.shared.view.BaseView
import com.example.bitcoin_tracker.user.User

interface LoginContract {

    interface View : BaseView {
    }

    interface Presenter {
        @Throws(InvalidUserLoginException::class)
        fun login(userEmail: String, userPassword: String): User
    }
}