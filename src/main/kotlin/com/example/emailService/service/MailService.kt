package com.example.emailService.service

import com.example.emailService.repository.MailRepository
import com.example.emailService.entity.Mail

import org.springframework.stereotype.Service

@Service
class MailService(val emailRepository: MailRepository)
{
    fun findAllMail() = emailRepository.findAllMail()
    fun findPendingMail() = emailRepository.findPendingMail()

    fun postMail(mail: Mail)
    {
        emailRepository.save(mail)
    }
}