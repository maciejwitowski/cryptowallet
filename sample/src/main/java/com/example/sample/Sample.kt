package com.example.sample

import com.example.solanaclient.Client
import com.example.solanaclient.KeyPair
import kotlinx.coroutines.runBlocking

fun main() {
  println("Let's say hello to a Solana account...")

  val baseUrl = "http://127.0.0.1:8899"
  val publicKey = intArrayOf(
    226, 176, 33, 0, 230, 122, 12, 16,
    99, 45, 7, 249, 84, 216, 211, 169,
    210, 157, 16, 126, 106, 209, 37, 143,
    97, 52, 140, 199, 32, 199, 15, 186
  ).map { it.toByte() }.toByteArray()

  val secret = intArrayOf(
    38, 185, 165, 161, 64, 61, 107, 84, 203, 193, 50,
    218, 79, 13, 159, 171, 18, 79, 118, 61, 45, 205,
    53, 154, 103, 23, 31, 244, 133, 135, 208, 16, 226,
    176, 33, 0, 230, 122, 12, 16, 99, 45, 7, 249,
    84, 216, 211, 169, 210, 157, 16, 126, 106, 209, 37,
    143, 97, 52, 140, 199, 32, 199, 15, 186
  ).map { it.toByte() }.toByteArray()


  val keyPair = KeyPair(
    public = publicKey,
    secret = secret
  )

  val client = Client(baseUrl)
  runBlocking {
    println("Connection to cluster established: ${client.getVersion()}")

    val blockhash = client.getRecentBlockhash()
    println("Blockhash: $blockhash")

    val balance = client.getBalance(keyPair.public)
    println("Balance: $balance")
  }
}
