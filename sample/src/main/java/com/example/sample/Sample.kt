package com.example.sample

import com.example.solanaclient.*
import kotlinx.coroutines.runBlocking

val client = Client("http://127.0.0.1:8899")

fun main() {
  println("Let's say hello to a Solana account...")

  val payer = getPayer()
  runBlocking {
    println("Connection to cluster established: ${client.getVersion()}")

    val blockhash = client.getRecentBlockhash()
    println("Blockhash: $blockhash")

    val balance = client.getBalance(payer.public)
    println("Balance: $balance")

    val program = getProgramKeypair()
    val programAccountInfo = client.getAccountInfo(program.public)
    println("programAccountInfo: $programAccountInfo")

    if (programAccountInfo.value == null) {
      println("Program probably wasn't deployed. Returning...")
    } else {
      val instructions = listOf(
        TransactionInstruction(
          pubKeys = listOf(
            AccountMeta(
              publicKey = payer.public,
              isSigner = false,
              isWritable = true
            )
          ),
          programId = program.public
        )
      )

      val transactionResponse = client.sendTransaction(Transaction(instructions), payer)
      println("Transaction response: $transactionResponse")
    }
  }
}

private fun getPayer(): KeyPair {
  val publicKey = intArrayOf(
    196, 1, 112, 204, 253, 0, 116, 162,
    51, 177, 34, 97, 1, 204, 169, 65,
    127, 72, 193, 58, 62, 217, 236, 46,
    238, 138, 201, 219, 62, 168, 165, 21
  ).map { it.toByte() }.toByteArray()

  val secret = intArrayOf(
    57, 54, 212, 125, 240, 170, 112, 192, 103, 193, 103,
    146, 251, 103, 238, 87, 189, 182, 80, 118, 237, 66,
    46, 76, 24, 125, 76, 134, 44, 167, 20, 123, 196,
    1, 112, 204, 253, 0, 116, 162, 51, 177, 34, 97,
    1, 204, 169, 65, 127, 72, 193, 58, 62, 217, 236,
    46, 238, 138, 201, 219, 62, 168, 165, 21
  ).map { it.toByte() }.toByteArray()


  return KeyPair(
    public = publicKey,
    secret = secret
  )
}

private fun getProgramKeypair(): KeyPair {
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


  return KeyPair(
    public = publicKey,
    secret = secret
  )
}
