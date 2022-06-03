package com.example.emailService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class EmailServiceApplication

fun main(args: Array<String>) {
	runApplication<EmailServiceApplication>(*args)
}

@Table("MAILS")
data class Mail(
	@Id
	val id: String?,
	val email: String,
	val subject: String,
	val content: String
)

@RestController
class MailController(val service: MailService)
{
	@CrossOrigin(origins = ["http://localhost:3000"])
	@GetMapping("/api/mail")
	fun findAllMail(): List<Mail> = service.findAllMail()

	@CrossOrigin(origins = ["http://localhost:3000"])
	@PostMapping("/api/mail")
	fun postMail(@RequestBody mail: Mail)
	{
		service.postMail(mail)
	}
}

@Service
class MailService(val db: MailRepository)
{
	fun findAllMail(): List<Mail> = db.findAllMail()

	fun postMail(mail: Mail)
	{
		db.save(mail)
	}
}

interface MailRepository : CrudRepository<Mail, String>
{
	@Query("SELECT * FROM mails")
	fun findAllMail(): List<Mail>
}