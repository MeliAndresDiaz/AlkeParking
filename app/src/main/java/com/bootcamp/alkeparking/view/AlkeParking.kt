package com.bootcamp.alkeparking.view

import com.bootcamp.alkeparking.data.Parking
import com.bootcamp.alkeparking.data.Vehicle
import com.bootcamp.alkeparking.utils.*
import java.util.*

fun main() {
    println("Bienvenido a AlkeParking, por favor escoge una opción")
    startAlkerParking()
}

private fun startAlkerParking() {

    var parking = Parking(mutableSetOf())
    var continueProgram = true
    while (continueProgram) {

        println("""
            1. Ingresar vehículo 
            2. Retirar vehículo
            3. Vehículos retirados y sus ganacias
            4. Vehículos en el parqueadero
            5. Salir""".trimIndent())
        val reader = Scanner(System.`in`)
            when (reader.nextInt()) {
                1 -> {
                    val inserted: Boolean = parking.addVehicle(Vehicle(
                        getLicensePlate(),
                        getVehicleType(),
                        Calendar.getInstance(),
                        hasDiscountCard()
                    ))
                    if(inserted) println("Ingreso exitoso")
                    else println("Lo siento, falló el ingreso del vehículo")
                }

                2 -> {
                    val licensePlateRemove = getLicensePlate()
                    parking.checkOutVehicle(licensePlateRemove)
                }

                5 -> continueProgram = false

                else -> showErrorMessage("Por favor escoge una opción válida")
            }
            println(parking.vehicles.size)
    }
}

