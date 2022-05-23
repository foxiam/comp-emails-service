package com.tinkoff.compEmailsService.repository

import com.tinkoff.compEmailsService.entity.LeakSource
import org.springframework.data.jpa.repository.JpaRepository

interface LeakSourceRepo : JpaRepository<LeakSource, Long>
