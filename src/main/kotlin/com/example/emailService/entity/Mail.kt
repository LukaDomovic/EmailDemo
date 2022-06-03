package com.example.emailService.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MAILS")
data class Mail(
    @Id
    val id: String?,
    val email: String,
    val subject: String,
    val content: String,
    var pending: Boolean
)