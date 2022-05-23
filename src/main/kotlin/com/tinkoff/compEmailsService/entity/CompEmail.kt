package com.tinkoff.compEmailsService.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tinkoff.compEmailsService.model.CompEmailDto
import com.tinkoff.compEmailsService.model.LeakSourceDto
import javax.persistence.*

@Entity
@Table(name = "comp_emails")
class CompEmail (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val address: String? = null,

    @JsonIgnore
    @ManyToMany(mappedBy = "compEmails")
    var leakSources: Set<LeakSource> = setOf()
) {
    fun toModel() = CompEmailDto(
        address = address!!,
        leakSources = leakSources.map {
            LeakSourceDto(
                source = it.source ?: "unknown",
                date = it.date ?: "unknown"
            )
        }.toSet()
    )
}