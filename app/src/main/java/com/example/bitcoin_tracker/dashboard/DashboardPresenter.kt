package com.example.bitcoin_tracker.dashboard

import com.example.bitcoin_tracker.dashboard.DashboardContract.Presenter
import com.example.bitcoin_tracker.dashboard.wallet.*
import com.example.bitcoin_tracker.shared.config.AppDatabase

class DashboardPresenter : Presenter {
    private var walletDao: WalletDao? = null
    private var walletCoinAmountDao: WalletCoinAmountDao? = null

    constructor(database: AppDatabase) {
        this.walletDao = database.walletDao()
        this.walletCoinAmountDao = database.walletCoinAmoutDao()
    }

    override fun getWalletByUserId(userId: Long): WalletDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addNewCoinToWallet(walletId: Long, coin: CoinEnum) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addCoinQuantityToWallet(coin: CoinEnum, quantity: Int, walletId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getWallet(userId: Long): Wallet? {
        return walletDao?.getWalletByUserId(userId)
    }

    private fun getWalletCoinAmountByWalletId(walletId: Long): WalletCoinAmount? {
        return walletCoinAmountDao?.getWalletCoinAmountByWalletId(walletId)
    }
}