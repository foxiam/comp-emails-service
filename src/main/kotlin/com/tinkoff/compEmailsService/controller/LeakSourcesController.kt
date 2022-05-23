package com.tinkoff.compEmailsService.controller

import com.tinkoff.compEmailsService.entity.LeakSource
import com.tinkoff.compEmailsService.service.LeakSourceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/add")
class LeakSourcesController (
    private val leakSourceService: LeakSourceService,
) {

    @PostMapping("/leak-source")
    fun addLeakSource(@RequestBody leakSource: LeakSource) {
        leakSourceService.addLeakSource(leakSource)
    }

}