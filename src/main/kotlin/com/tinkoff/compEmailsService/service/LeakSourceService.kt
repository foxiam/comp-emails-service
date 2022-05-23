package com.tinkoff.compEmailsService.service

import com.tinkoff.compEmailsService.repository.CompEmailRepo
import com.tinkoff.compEmailsService.repository.LeakSourceRepo
import com.tinkoff.compEmailsService.entity.CompEmail
import com.tinkoff.compEmailsService.entity.LeakSource
import org.springframework.stereotype.Service

@Service
class LeakSourceService(
    private val leakSourceRepo: LeakSourceRepo,
    private val compEmailRepo: CompEmailRepo,
    private val subscriberService: SubscriberService
) {

    fun addLeakSource(leakSource: LeakSource) {
        val compEmails = mutableSetOf<CompEmail>()
        leakSource.compEmails.forEach { compEmail ->
            val compEmailFromDB = compEmailRepo.findByAddress(compEmail.address) ?: compEmail
            compEmails.add(compEmailFromDB)
        }
        leakSource.compEmails = compEmails
        leakSourceRepo.save(leakSource)
        subscriberService.sendNewLeakSource(leakSource)
    }

}