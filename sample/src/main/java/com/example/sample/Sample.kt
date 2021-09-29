package com.example.sample

import com.example.solanaclient.Client
import kotlinx.coroutines.runBlocking

fun main() {
  println("Let's say hello to a Solana account...")

  val baseUrl = "http://127.0.0.1:8899"
  val client = Client(baseUrl)
  runBlocking {
    println(client.getVersion())
  }
}
