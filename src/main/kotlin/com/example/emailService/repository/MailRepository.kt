package com.example.emailService.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import com.example.emailService.entity.Mail

@Repository
interface MailRepository : CrudRepository<Mail, String>
{
    @Query("SELECT * FROM mails")
    fun findAllMail(): List<Mail>

    @Query("SELECT * FROM mails WHERE mails.pending = true")
    fun findPendingMail(): List<Mail>
}