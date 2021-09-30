package com.example.solanaclient.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetRecentBlockhashRequest(
  val jsonrpc: String,
  val id: Long,
  val method: String
) {
  companion object {
    fun build(id: Long) =
      GetRecentBlockhashRequest("2.0", id, "getRecentBlockhash")
  }
}

@JsonClass(generateAdapter = true)
data class GetRecentBlockhashResponseWrapper(
  val result: GetRecentBlockhashResult
)

@JsonClass(generateAdapter = true)
data class GetRecentBlockhashResult(
  @Json(name = "value")
  val value: GetRecentBlockhashValue
)

@JsonClass(generateAdapter = true)
data class GetRecentBlockhashValue(
  val blockhash: String,

  @Json(name = "feeCalculator")
  val feeCalculator: FeeCalculator
)

@JsonClass(generateAdapter = true)
data class FeeCalculator(
  @Json(name = "lamportsPerSignature")
  val lamportsPerSignature: Int
)
