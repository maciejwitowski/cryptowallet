package com.example.solanaclient

import com.example.solanaclient.api.GetBalanceRequest
import com.example.solanaclient.api.GetBalanceResponseWrapper
import com.example.solanaclient.api.GetRecentBlockhashRequest
import com.example.solanaclient.api.GetRecentBlockhashResponseWrapper
import okhttp3.OkHttpClient
import okio.ByteString.Companion.decodeBase64
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response as RetrofitResponse

internal class SolanaApi(baseUrl: String) {
  private val client by lazy {
    Retrofit
      .Builder()
      .baseUrl(baseUrl)
      .client(OkHttpClient())
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }

  val solana: SolanaService by lazy { client.create(SolanaService::class.java) }
}

internal interface SolanaService {
  @POST("/")
  suspend fun getVersion(@Body request: GetVersionRequest): RetrofitResponse<GetVersionResponseWrapper>

  @POST("/")
  suspend fun getRecentBlockhash(@Body request: GetRecentBlockhashRequest): RetrofitResponse<GetRecentBlockhashResponseWrapper>

  @POST("/")
  suspend fun getBalance(@Body request: GetBalanceRequest): RetrofitResponse<GetBalanceResponseWrapper>
}

