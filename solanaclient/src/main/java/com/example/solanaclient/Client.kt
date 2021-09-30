package com.example.solanaclient

import com.example.solanaclient.api.*
import com.example.solanaclient.utils.encodeToBase58String

class Client(baseUrl: String) {
  private val api = SolanaApi(baseUrl)

  suspend fun getAccountInfo(pubKey: ByteArray): GetAccountInfoResult =
    api.solana.getAccountInfo(
      GetAccountInfoRequest.build(1, pubKey.encodeToBase58String())
    ).body()!!.result

  suspend fun getVersion(): GetVersionResponse =
    api.solana.getVersion(GetVersionRequest.build(1)).body()!!.result

  suspend fun getRecentBlockhash(): GetRecentBlockhashResult =
    api.solana.getRecentBlockhash(GetRecentBlockhashRequest.build(1)).body()!!.result

  suspend fun getBalance(pubKey: ByteArray): GetBalanceResult =
    api.solana.getBalance(GetBalanceRequest.build(1, pubKey.encodeToBase58String())).body()!!.result

  suspend fun sendTransaction(transaction: Transaction, signer: KeyPair): SentTransactionResponse =
    api.solana.sendTransaction(SendTransactionRequest.build(1, "")).body()!! // TODO Encode transaction
}

