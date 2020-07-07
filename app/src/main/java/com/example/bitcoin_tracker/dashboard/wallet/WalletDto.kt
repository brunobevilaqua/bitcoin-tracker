package com.example.bitcoin_tracker.dashboard.wallet

class WalletDto(
    val walletId: Long?,
    val userId: Long?,
    val walletTotalAmount: Long?,
    val coins: List<WalletCoinAmount>?
) {
    data class Builder(
        var walletId: Long?,
        var userId: Long?,
        var walletTotalAmount: Long?,
        var coins: List<WalletCoinAmount>?
    ) {
        fun walletId(walletId: Long) = apply { this.walletId = walletId }
        fun userId(userId: Long) = apply { this.userId = userId }
        fun walletTotalAmount(walletTotalAmount: Long) =
            apply { this.walletTotalAmount = walletTotalAmount }
        fun coins(coins: List<WalletCoinAmount>) = apply { this.coins = coins }
        fun build() = WalletDto(walletId, userId, walletTotalAmount, coins)
    }
}