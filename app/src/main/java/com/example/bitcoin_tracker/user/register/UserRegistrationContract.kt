package com.example.bitcoin_tracker.user.register

import com.example.bitcoin_tracker.shared.view.BaseView

interface UserRegistrationContract {

    interface View : BaseView {
    }

    interface Presenter {
        fun registerUser(
            userFirstName: String,
            userLastName: String,
            userEmail: String,
            userPassword: String
        )
    }

}