package com.tinkoff.compEmailsService.service

import com.tinkoff.compEmailsService.entity.LeakSource
import com.tinkoff.compEmailsService.entity.Subscriber
import com.tinkoff.compEmailsService.repository.SubscriberRepo
import com.tinkoff.compEmailsService.service.client.SubscriberClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class SubscriberService(
    private val subscriberRepo: SubscriberRepo,
    private val subscriberClient: SubscriberClient
    ) {

    fun addSubscriber(subscriber: Subscriber) {
        subscriberRepo.save(subscriber)
    }

    fun sendNewLeakSource(leakSource: LeakSource) {
        CoroutineScope(Dispatchers.Default).launch {
            val subscribers = withContext(Dispatchers.IO) {
                subscriberRepo.findAll()
            }
            subscribers.forEach {
                subscriberClient.sendNewLeakSource(it, leakSource)
            }
        }
    }

}