package com.example.bitcoin_tracker.dashboard

import com.example.bitcoin_tracker.dashboard.wallet.CoinEnum
import com.example.bitcoin_tracker.dashboard.wallet.WalletDto
import com.example.bitcoin_tracker.shared.view.BaseView

interface DashboardContract {
    interface View : BaseView {

    }

    interface Presenter {
        fun getWalletByUserId(userId: Long): WalletDto
        fun addNewCoinToWallet(walletId: Long, coin: CoinEnum)
        fun addCoinQuantityToWallet(coin: CoinEnum, quantity: Int, walletId: Long)
    }
}