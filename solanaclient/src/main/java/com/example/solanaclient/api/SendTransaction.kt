package com.example.solanaclient.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SendTransactionRequest(
  val jsonrpc: String,
  val id: Long,
  val method: String,
  val params: List<String>
) {
  companion object {
    fun build(id: Long, encodedTransaction: String) =
      SendTransactionRequest("2.0", id, "sendTransaction", listOf(encodedTransaction))
  }
}

@JsonClass(generateAdapter = true)
data class SentTransactionResponse(
  val result: String?
)
