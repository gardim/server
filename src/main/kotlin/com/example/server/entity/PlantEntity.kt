package com.example.server.entity

import jakarta.persistence.*

@Entity
@Table(name = "plants")
class PlantEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0,

    @Column(name = "name", length = Integer.MAX_VALUE)
    var name: String = "",

    @Column(name = "photo_url", length = Integer.MAX_VALUE)
    var photoUrl: String = "",

    @Column(name = "latitude")
    var latitude: Double = 0.0,

    @Column(name = "longitude")
    var longitude: Double = 0.0,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    var device: DeviceEntity,
)