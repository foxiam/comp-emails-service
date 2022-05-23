package com.tinkoff.compEmailsService.repository

import com.tinkoff.compEmailsService.entity.CompEmail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CompEmailRepo : JpaRepository<CompEmail, Long> {

    fun findByAddress(address: String?): CompEmail?

    @Query("select c from  CompEmail c join c.leakSources ls where c.address = ?1 and ls.source = ?2")
    fun findByAddressAndSource(address: String?, leakSource: String?): CompEmail?
}