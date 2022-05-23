package com.tinkoff.compEmailsService.model

data class CompEmailDto (
    val address: String,
    var leakSources: Set<LeakSourceDto> = setOf()
)