package com.example.emailService.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailSenderService (private val emailSender: JavaMailSender) {

    fun sendEmail(subject: String, content: String, email: String)
    {
        val emailMessage = SimpleMailMessage()
        emailMessage.setSubject(subject)
        emailMessage.setText(content)
        emailMessage.setTo(email)

        emailSender.send(emailMessage)
    }
}