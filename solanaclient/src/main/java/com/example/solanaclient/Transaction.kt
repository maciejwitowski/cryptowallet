package com.example.solanaclient

class Transaction(
  val instructions: List<TransactionInstruction>
)

class TransactionInstruction(
  val pubKeys: List<AccountMeta>,
  val programId: ByteArray
)

class AccountMeta(
  val publicKey: ByteArray,
  val isSigner: Boolean,
  val isWritable: Boolean
)
