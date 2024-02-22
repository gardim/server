package com.example.server.controller

import com.example.server.entity.DeviceEntity
import com.example.server.service.DeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/devices")
class DeviceController @Autowired constructor(private val deviceService: DeviceService) {
    @get:GetMapping
    val allDevices: List<DeviceEntity?>
        get() = deviceService.allDevices

    @GetMapping("/{id}")
    fun getDeviceById(@PathVariable id: Long?): Optional<DeviceEntity?> {
        return deviceService.getDeviceById(id!!)
    }

    @GetMapping("/user/{userId}")
    fun getDevicesByUserId(@PathVariable userId: Long?): List<DeviceEntity?>? {
        return deviceService.getDevicesByUserId(userId)
    }

    @PostMapping
    fun saveDevice(@RequestBody device: DeviceEntity?): DeviceEntity {
        return deviceService.saveDevice(device!!)
    }

    @PutMapping("/{id}")
    fun updateDevice(@PathVariable id: Long?, @RequestBody updatedDevice: DeviceEntity?): Optional<DeviceEntity> {
        return deviceService.updateDevice(id!!, updatedDevice!!)
    }

    @DeleteMapping("/{id}")
    fun deleteDevice(@PathVariable id: Long?) {
        deviceService.deleteDevice(id!!)
    }
}