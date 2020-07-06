package com.example.bitcoin_tracker.dashboard.wallet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bitcoin_tracker.user.User

@Dao
interface WalletDao {

    @Query("SELECT * FROM wallet")
    fun findAllWallets(): List<Wallet>

    @Query("SELECT * FROM wallet WHERE USER_ID = :userId")
    fun getWalletByUserId(userId: Long): Wallet

    @Insert
    fun createWallet(wallet: Wallet)

    @Update
    fun updateWallet(wallet: Wallet)

}