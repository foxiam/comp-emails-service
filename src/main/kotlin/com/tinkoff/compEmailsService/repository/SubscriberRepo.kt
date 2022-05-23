package com.tinkoff.compEmailsService.repository

import com.tinkoff.compEmailsService.entity.Subscriber
import org.springframework.data.jpa.repository.JpaRepository

interface SubscriberRepo: JpaRepository<Subscriber, Long>