package com.example.solanaclient

import com.example.solanaclient.api.GetBalanceRequest
import com.example.solanaclient.api.GetBalanceResult
import com.example.solanaclient.api.GetRecentBlockhashRequest
import com.example.solanaclient.api.GetRecentBlockhashResult
import com.example.solanaclient.utils.encodeToBase58String

class Client(baseUrl: String) {
  private val api = SolanaApi(baseUrl)

  suspend fun getVersion(): GetVersionResponse =
    api.solana.getVersion(GetVersionRequest.build(1)).body()!!.result

  suspend fun getRecentBlockhash(): GetRecentBlockhashResult =
    api.solana.getRecentBlockhash(GetRecentBlockhashRequest.build(1)).body()!!.result

  suspend fun getBalance(pubKey: ByteArray): GetBalanceResult =
    api.solana.getBalance(GetBalanceRequest.build(1, pubKey.encodeToBase58String())).body()!!.result
}

