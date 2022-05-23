package com.tinkoff.compEmailsService.controller

import com.tinkoff.compEmailsService.entity.Subscriber
import com.tinkoff.compEmailsService.service.CompEmailService
import com.tinkoff.compEmailsService.service.SubscriberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController(
    private val compEmailService: CompEmailService,
    private val subscriberService: SubscriberService
) {

    @GetMapping("/email/{address}")
    fun getEmailByAddress(@PathVariable address: String) =
        compEmailService.getEmailByAddress(address)

    @PostMapping("/subscribe")
    fun subscriptionToSendingNotification(subscriber: Subscriber) {
        subscriberService.addSubscriber(subscriber)
    }

    @GetMapping("/email/{address}/{source}")
    fun getEmailByAddressAndSource(@PathVariable address: String, @PathVariable source: String) =
        compEmailService.getEmailByAddressAndSource(address, source)
}