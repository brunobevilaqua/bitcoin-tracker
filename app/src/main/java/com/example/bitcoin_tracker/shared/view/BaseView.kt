package com.example.bitcoin_tracker.shared.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(error: String)
}