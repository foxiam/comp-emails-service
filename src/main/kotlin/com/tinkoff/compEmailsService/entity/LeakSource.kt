package com.tinkoff.compEmailsService.entity

import javax.persistence.*

@Entity
@Table(name = "leak_source")
class LeakSource (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val source: String? = null,

    val date: String? = null,

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "comp_emails_leak_sources",
        joinColumns = [JoinColumn(name = "source_id")],
        inverseJoinColumns = [JoinColumn(name = "email_id")]
    )
    var compEmails: Set<CompEmail> = setOf()
)