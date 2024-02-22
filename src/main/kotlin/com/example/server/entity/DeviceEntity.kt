package com.example.server.entity

import jakarta.persistence.*

@Entity
@Table(name = "devices")
class DeviceEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "frequency")
    var frequency: Int = 0,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: UserEntity? = null,
)