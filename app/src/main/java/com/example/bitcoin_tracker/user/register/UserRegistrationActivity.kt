package com.example.bitcoin_tracker.user.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bitcoin_tracker.R
import com.example.bitcoin_tracker.shared.config.AppDatabase
import com.example.bitcoin_tracker.user.login.LoginActivity
import kotlinx.android.synthetic.main.activity_user_registration.*

class UserRegistrationActivity : AppCompatActivity() {
    private var presenter: UserRegistrationPresenter? = null
    private var database: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)
        setupDatabaseAndPresenter(applicationContext)
        userRegistrationButton.setOnClickListener(View.OnClickListener {
            registerNewUser()
        });
    }

    private fun setupDatabaseAndPresenter(context: Context) {
        setupDatabaseInstance(context)
        setupPresenter()
    }

    private fun setupPresenter() {
        presenter = database?.let { UserRegistrationPresenter(it) }
    }

    private fun setupDatabaseInstance(context: Context) {
        database = AppDatabase.invoke(context)
    }

    private fun registerNewUser() {
        if (isUserRegistrationInputsValid()) {
            presenter?.registerUser(
                getUserFirstNameInput(),
                getUserLastNameInput(),
                getUserEmailInput(),
                getUserPasswordInput()
            )
            Toast.makeText(this, "User registration created.", Toast.LENGTH_LONG).show()
            redirectToLoginScreen()
        } else {
            Toast.makeText(this, "Invalid inputs.", Toast.LENGTH_LONG).show()
        }
    }

    private fun isUserRegistrationInputsValid(): Boolean {
        return isUserFirstNameValid(getUserFirstNameInput())
                && isUserLastNameValid(getUserLastNameInput())
                && isUserEmailValid(getUserEmailInput())
                && isUserPasswordValid(getUserPasswordInput())
    }

    private fun getUserFirstNameInput(): String {
        return registrationScreenUserFirstName.text.toString()
    }

    private fun getUserLastNameInput(): String {
        return registrationScreenUserLastName.text.toString()
    }

    private fun getUserEmailInput(): String {
        return registrationScreenUserEmail.text.toString()
    }

    private fun getUserPasswordInput(): String {
        return registrationScreenUserPassword.text.toString()
    }

    private fun isUserFirstNameValid(firstName: String): Boolean {
        return firstName.isNotBlank()
    }

    private fun isUserLastNameValid(lastName: String): Boolean {
        return lastName.isNotBlank()
    }

    private fun isUserEmailValid(email: String): Boolean {
        return email.isNotBlank()
    }

    private fun isUserPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }

    private fun redirectToLoginScreen() {
        val loginActivity = Intent(this, LoginActivity::class.java)
        startActivity(loginActivity)
    }
}
