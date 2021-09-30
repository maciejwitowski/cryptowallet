package com.example.solanaclient.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetBalanceRequest(
  val jsonrpc: String,
  val id: Long,
  val method: String,
  val params: List<String>
) {
  companion object {
    fun build(id: Long, publicKey: String) =
      GetBalanceRequest("2.0", id, "getBalance", listOf(publicKey))
  }
}

@JsonClass(generateAdapter = true)
data class GetBalanceResponseWrapper(
  val result: GetBalanceResult
)

@JsonClass(generateAdapter = true)
data class GetBalanceResult(
  @Json(name = "value")
  val value: Int
)

@JsonClass(generateAdapter = true)
data class GetBalanceContext(
  val value: Long,
)
