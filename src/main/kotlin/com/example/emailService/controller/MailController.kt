package com.example.emailService.controller

import org.springframework.web.bind.annotation.*

import com.example.emailService.service.MailService
import com.example.emailService.service.MailSenderService
import com.example.emailService.entity.Mail
import org.springframework.scheduling.annotation.Scheduled

@RestController
class MailController(val service: MailService, val sendService: MailSenderService)
{
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/api/mail")
    fun findAllMail(): List<Mail> = service.findAllMail()

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/api/mail/pending")
    fun findPendingMail(): List<Mail> = service.findPendingMail()

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/api/mail")
    fun postMail(@RequestBody mail: Mail)
    {
        service.postMail(mail)
    }

    @Scheduled(fixedDelay = 10000)
    fun sendPendingEmail()
    {
        val pendingMail: List<Mail> = findPendingMail()

        if(pendingMail.isNotEmpty())
        {
            try {
                sendService.sendEmail(pendingMail[0].subject, pendingMail[0].content, pendingMail[0].email)
                pendingMail[0].pending = false
                postMail(pendingMail[0])
            }
            catch (e: Exception)
            {
                System.out.println(e.message)
            }
        }
    }
}