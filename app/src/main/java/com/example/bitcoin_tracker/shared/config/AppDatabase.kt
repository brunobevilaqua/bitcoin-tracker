package com.example.bitcoin_tracker.shared.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bitcoin_tracker.dashboard.wallet.Wallet
import com.example.bitcoin_tracker.dashboard.wallet.WalletCoinAmount
import com.example.bitcoin_tracker.dashboard.wallet.WalletCoinAmountDao
import com.example.bitcoin_tracker.dashboard.wallet.WalletDao
import com.example.bitcoin_tracker.user.User
import com.example.bitcoin_tracker.user.UserDao

@Database(
    entities = [User::class, Wallet::class, WalletCoinAmount::class],
    version = 2,
    exportSchema = false
)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun walletDao(): WalletDao
    abstract fun walletCoinAmoutDao(): WalletCoinAmountDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "bitcoin-tracker.db"
        )
            .allowMainThreadQueries()
            .build()
    }

}