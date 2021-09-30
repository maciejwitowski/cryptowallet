package com.example.solanaclient

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetVersionRequest(
  val jsonrpc: String,
  val id: Long,
  val method: String
) {
  companion object {
    fun build(id: Long) =
      GetVersionRequest("2.0", id, "getVersion")
  }
}

@JsonClass(generateAdapter = true)
data class GetVersionResponseWrapper(
  val result: GetVersionResponse
)

@JsonClass(generateAdapter = true)
data class GetVersionResponse(
  @Json(name = "solana-core")
  val solanaCore: String
)
