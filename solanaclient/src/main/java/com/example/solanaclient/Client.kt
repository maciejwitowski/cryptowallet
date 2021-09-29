package com.example.solanaclient

class Client(baseUrl: String) {
  private val api = SolanaApi(baseUrl)

  suspend fun getVersion(): GetVersionResponseWrapper =
    api.solana.getVersion(
      GetVersionRequest.build(1)
    ).body()!!
}

