package com.bootcamp.alkeparking.view

import com.bootcamp.alkeparking.data.Vehicle
import com.bootcamp.alkeparking.utils.*
import java.util.*

fun main() {
    println("Bienvenido a AlkeParking, por favor escoge una opción")
    startAlkerParking()
}

private fun startAlkerParking() {
    println("1. Ingresar vehiculo \n2. Retirar Vehiculo")
    val reader = Scanner(System.`in`)

    when (reader.nextInt()) {
        1 -> {
            addVehicle(
                Vehicle(
                    getLicensePlate(),
                    getVehicleType(),
                    Calendar.getInstance(),
                    hasDiscountCard()
                )
            )
        }

        2 -> {

        }

        else -> showErrorMessage("Por favor escoge una opcion valida")
    }
}
