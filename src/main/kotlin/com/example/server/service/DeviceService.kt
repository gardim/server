package com.example.server.service

import com.example.server.entity.DeviceEntity
import com.example.server.repository.DeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DeviceService @Autowired constructor(private val deviceRepository: DeviceRepository) {
    val allDevices: List<DeviceEntity?>
        get() = deviceRepository.findAll()

    fun getDeviceById(id: Long): Optional<DeviceEntity?> {
        return deviceRepository.findById(id)
    }

    fun saveDevice(device: DeviceEntity): DeviceEntity {
        return deviceRepository.save(device)
    }

    fun updateDevice(id: Long, updatedDevice: DeviceEntity): Optional<DeviceEntity> {
        if (deviceRepository.existsById(id)) {
            updatedDevice.id = id
            return Optional.of(deviceRepository.save(updatedDevice))
        }
        return Optional.empty()
    }

    fun deleteDevice(id: Long) {
        deviceRepository.deleteById(id)
    }
}