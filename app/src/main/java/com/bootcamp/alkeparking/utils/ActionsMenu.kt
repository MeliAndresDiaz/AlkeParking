package com.bootcamp.alkeparking.utils

import com.bootcamp.alkeparking.data.Vehicle
import java.util.*

var reader = Scanner(System.`in`)

fun addVehicle(vehicle: Vehicle) {
    println(vehicle.licensePlate)
}

fun getLicensePlate(): String {
    println("Digita la placa de tu vehículo: ")
    return readLine()!!.uppercase()
}

fun getVehicleType(): VehicleType {
    println("""
        Por favor escoge el tipo de vehículo:
        1. Auto
        2. Moto
        3. Mini Bus
        4. Bus""".trimIndent())

    when (reader.nextInt()) {
        1 -> {
            return VehicleType.Car
        }

        2 -> {
            return VehicleType.Motorcycle
        }

        3 -> {
            return VehicleType.MiniBus
        }

        4 -> {
            return VehicleType.Bus
        }

        else -> showErrorMessage("Por favor escoge un tipo de vehículo válido")
    }
}

fun hasDiscountCard(): String? {
    println("""
        ¿El vehículo cuenta con una tarjeta de descuentos?
        1. Si
        2. No""".trimIndent())
    return when (reader.nextInt()) {
        1 -> {
            println("Por favor digita el código de la tarjeta de descuento: ")
            readLine()!!.uppercase()
        }

        2 -> {
            null
        }

        else -> {
            showErrorMessage("Por favor escoge una opción válida")
        }
    }
}