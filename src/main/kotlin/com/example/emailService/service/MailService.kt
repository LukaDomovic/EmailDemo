package com.example.emailService.service

import com.example.emailService.repository.MailRepository
import com.example.emailService.entity.Mail

import org.springframework.stereotype.Service

@Service
class MailService(val db: MailRepository)
{
    fun findAllMail(): List<Mail> = db.findAllMail()
    fun findPendingMail(): List<Mail> = db.findPendingMail()

    fun postMail(mail: Mail)
    {
        db.save(mail)
    }
}