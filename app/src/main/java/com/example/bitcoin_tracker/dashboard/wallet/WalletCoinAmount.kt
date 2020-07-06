package com.example.bitcoin_tracker.dashboard.wallet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class WalletCoinAmount(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "WALLET_COIN_AMOUNT_ID") val walletCoinAmountId: Long = 0,
    @ColumnInfo(name = "WALLET_ID") val walletId: Long,
    @ColumnInfo(name = "COIN") val coin: String,
    @ColumnInfo(name = "QUANTITY") val quantity: Long
)