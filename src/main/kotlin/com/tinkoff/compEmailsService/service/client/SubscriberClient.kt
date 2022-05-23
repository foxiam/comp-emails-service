package com.tinkoff.compEmailsService.service.client

import com.tinkoff.compEmailsService.entity.LeakSource
import com.tinkoff.compEmailsService.entity.Subscriber
import com.tinkoff.compEmailsService.model.LeakSourceDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodyOrNull
import reactor.core.publisher.Mono

@Component
class SubscriberClient(private val webClient: WebClient) {

    suspend fun sendNewLeakSource(subscriber: Subscriber, leakSource: LeakSource) {
        webClient.post()
            .uri(subscriber.url!!)
            .body(Mono.just(leakSource), LeakSourceDto::class.java)
            .retrieve()
            .awaitBodyOrNull<LeakSourceDto>()
    }
}