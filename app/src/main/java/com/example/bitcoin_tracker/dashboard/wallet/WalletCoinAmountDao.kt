package com.example.bitcoin_tracker.dashboard.wallet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WalletCoinAmountDao {
    @Insert
    fun create(walletCoinAmount: WalletCoinAmount)

    @Update
    fun update(walletCoinAmount: WalletCoinAmount)

    @Query("SELECT * from walletcoinamount WHERE WALLET_ID= :walletId")
    fun getWalletCoinAmountByWalletId(walletId: Long): WalletCoinAmount
}