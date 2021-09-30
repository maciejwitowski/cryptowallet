package com.example.solanaclient.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetAccountInfoRequest(
  val jsonrpc: String,
  val id: Long,
  val method: String,
  val params: List<String>
) {
  companion object {
    fun build(id: Long, publicKey: String) =
      GetAccountInfoRequest("2.0", id, "getAccountInfo", listOf(publicKey))
  }
}

@JsonClass(generateAdapter = true)
data class GetAccountInfoResponseWrapper(
  val result: GetAccountInfoResult
)

@JsonClass(generateAdapter = true)
data class GetAccountInfoResult(
  @Json(name = "value")
  val value: GetAccountInfoValue?
)

@JsonClass(generateAdapter = true)
data class GetAccountInfoValue(
  val owner: String,
  val executable: Boolean,
)
