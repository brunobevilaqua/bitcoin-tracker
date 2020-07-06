package com.example.bitcoin_tracker.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bitcoin_tracker.R
import com.example.bitcoin_tracker.dashboard.add.AddCoinActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        dashboardScreenAddButton.setOnClickListener(View.OnClickListener {
            goToAddCoinScreen()
        })
    }

    private fun goToAddCoinScreen() {
        val addCoinActivity = Intent(this, AddCoinActivity::class.java)
        startActivity(addCoinActivity)
    }
}
