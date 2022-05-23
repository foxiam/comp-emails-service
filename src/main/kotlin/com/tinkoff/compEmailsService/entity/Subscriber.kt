package com.tinkoff.compEmailsService.entity

import javax.persistence.*

@Entity
@Table(name = "subscribers")
class Subscriber (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val url: String? = null
)