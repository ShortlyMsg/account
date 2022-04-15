package com.shortlymsg.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class CustomerAccountDto(
    val id: String,
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime?,
    val customer: AccountCustomerDto?,
    val transactions: Set<TransactionDto>?
) {
}