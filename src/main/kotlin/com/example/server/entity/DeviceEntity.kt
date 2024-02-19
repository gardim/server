package com.example.server.entity

import jakarta.persistence.*

@Entity
@Table(name = "devices")
class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "frequency")
    var frequency: Int = 0
}