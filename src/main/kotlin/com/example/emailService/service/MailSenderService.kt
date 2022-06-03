package com.example.emailService.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailSenderService (private val emailSender: JavaMailSender) {

    fun sendEmail(subject: String, content: String, email: String)
    {
        val message = SimpleMailMessage()
        message.setSubject(subject)
        message.setText(content)
        message.setTo(email)

        emailSender.send(message)
    }
}