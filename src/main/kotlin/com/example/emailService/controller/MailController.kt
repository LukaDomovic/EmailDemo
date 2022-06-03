package com.example.emailService.controller

import org.springframework.web.bind.annotation.*

import com.example.emailService.service.MailService
import com.example.emailService.service.MailSenderService
import com.example.emailService.entity.Mail
import org.springframework.scheduling.annotation.Scheduled
import java.util.function.Consumer

@RestController
class MailController(val mailService: MailService, val sendService: MailSenderService)
{
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/api/mail")
    fun findAllMail() = mailService.findAllMail()

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/api/mail/pending")
    fun findPendingMail() = mailService.findPendingMail()

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/api/mail")
    fun postMail(@RequestBody mail: Mail)
    {
        mailService.postMail(mail)
    }

    @Scheduled(fixedDelay = 10000)
    fun sendPendingEmail()
    {
        val pendingMail = findPendingMail()

        if(pendingMail.isNotEmpty())
        {
            pendingMail.forEach {
                try {
                    System.out.println("Sending: " + it.email)
                    sendService.sendEmail(it.subject, it.content, it.email)
                    it.pending = false
                    postMail(it)
                }
                catch (e: Exception)
                {
                    System.out.println(e.message)
                }
            }
        }
    }
}