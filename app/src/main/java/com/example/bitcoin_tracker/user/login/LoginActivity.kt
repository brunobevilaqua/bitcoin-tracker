package com.example.bitcoin_tracker.user.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bitcoin_tracker.R
import com.example.bitcoin_tracker.dashboard.DashboardActivity
import com.example.bitcoin_tracker.shared.config.AppDatabase
import com.example.bitcoin_tracker.shared.exception.InvalidUserLoginException
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var presenter: LoginPresenter? = null
    private var database: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupDatabaseAndPresenter(applicationContext)
        loginScreenButton.setOnClickListener(View.OnClickListener {
            login()
        })
    }

    private fun setupDatabaseAndPresenter(context: Context) {
        setupDatabaseInstance(context)
        setupPresenter()
    }

    private fun setupPresenter() {
        presenter = database?.let { LoginPresenter(it) }
    }

    private fun setupDatabaseInstance(context: Context) {
        database = AppDatabase.invoke(context)
    }

    private fun goToDashboardScreen() {
        val dashboardScreen = Intent(this, DashboardActivity::class.java)
        startActivity(dashboardScreen)
    }

    private fun isUserEmailValid(email: String): Boolean {
        return !email.isBlank()
    }

    private fun isUserPasswordValid(password: String): Boolean {
        return !password.isBlank()
    }

    private fun isUserInputLoginDataValid(): Boolean {
        return isUserEmailValid(getUserEmail()) && isUserPasswordValid(getUserPassword())
    }

    private fun showUserNotFoundErrorMessage() {
        Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show()
    }

    private fun showInvalidUserEmailAndPasswordInput() {
        Toast.makeText(this, "Invalid email and/or password.", Toast.LENGTH_SHORT).show()
    }

    private fun getUserEmail(): String {
        return loginScreenUserEmail.text.toString();
    }

    private fun getUserPassword(): String {
        return loginScreenUserPassword.text.toString()
    }

    private fun login() {
        try {
            if (isUserInputLoginDataValid()) {
                presenter?.login(getUserEmail(), getUserPassword())
                goToDashboardScreen()
            } else {
                showInvalidUserEmailAndPasswordInput()
            }
        } catch (e: InvalidUserLoginException) {
            showUserNotFoundErrorMessage()
        }
    }

}
