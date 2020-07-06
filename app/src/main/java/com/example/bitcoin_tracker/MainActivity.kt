package com.example.bitcoin_tracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bitcoin_tracker.user.login.LoginActivity
import com.example.bitcoin_tracker.user.register.UserRegistrationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClickOpenLogginScreen()
        onClickOpenRegistrationScreen()
    }

    private fun onClickOpenLogginScreen() {
        mainScreenSignInButton.setOnClickListener(View.OnClickListener {
            openUserLoginScreen()
        })
    }

    private fun onClickOpenRegistrationScreen() {
        mainScreenCreateNewAccountButton.setOnClickListener(View.OnClickListener {
            openUserRegistrationScreen()
        })
    }

    private fun openUserLoginScreen() {
        val loginActivity = Intent(this, LoginActivity::class.java)
        startActivity(loginActivity)
    }

    private fun openUserRegistrationScreen() {
        val userRegistrationScreen = Intent(this, UserRegistrationActivity::class.java)
        startActivity(userRegistrationScreen)
    }
}