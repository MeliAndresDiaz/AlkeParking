package com.bootcamp.alkeparking.utils

import com.bootcamp.alkeparking.data.Vehicle
import java.util.*

var reader = Scanner(System.`in`)

fun addVehicle(vehicle: Vehicle) {

}

fun getLicensePlate(): String {
    println("Digita la placa de tu vehiculo")
    return readLine()!!
}

fun getVehicleType(): VehicleType {
    println("Por favor escoge el tipo de vehiculo:\n 1. Auto \n 2. Moto \n 3. Mini Bus \n 4. Bus")

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

        else -> showErrorMessage("Por favor escoge un tipo de vehiculo valido")
    }
}

fun hasDiscountCard(): String? {
    println("¿El vehiculo cuenta con una tarjeta de descuentos?\n 1. Si \n 2. No")
    return when (reader.nextInt()) {
        1 -> {
            println("Por favor digita codigo de la tarjeta de descuento: ")
            readLine()
        }

        2 -> {
            null
        }

        else -> {
            showErrorMessage("Por favor escoge una opcion valida")
        }
    }
}