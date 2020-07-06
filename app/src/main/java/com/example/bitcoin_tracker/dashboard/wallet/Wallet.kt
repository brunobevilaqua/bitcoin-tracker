package com.example.bitcoin_tracker.dashboard.wallet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Wallet(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "WALLET_ID") val walletId: Long = 0,
    @ColumnInfo(name = "USER_ID") val userId: Long,
    @ColumnInfo(name = "WALLET_TOTAL_AMOUNT_OF_FUNDS") val walletTotalAmountOfFunds: Long
    )

