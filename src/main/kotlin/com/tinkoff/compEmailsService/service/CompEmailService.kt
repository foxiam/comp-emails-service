package com.tinkoff.compEmailsService.service

import com.tinkoff.compEmailsService.repository.CompEmailRepo
import org.springframework.stereotype.Service

@Service
class CompEmailService(val compEmailRepo: CompEmailRepo) {

    fun getEmailByAddress(address: String) =
        compEmailRepo.findByAddress(address)?.toModel()

    fun getEmailByAddressAndSource(address: String, source: String) =
        compEmailRepo.findByAddressAndSource(address, source)?.toModel()

}