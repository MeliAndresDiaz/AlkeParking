package com.bootcamp.alkeparking.data

import com.bootcamp.alkeparking.utils.AlkerParkingConstants
import com.bootcamp.alkeparking.utils.AlkerParkingConstants.MAXIMUM_LENGTH_VEHICLES

/**
 * ¿Por que se define vehicles como un Set?
 * R: Dadas las condiciones del ejercicio al no poder repertise los datos la opcion mas adecuada
 * es utilizar el set
 */

data class Parking(val vehicles: MutableSet<Vehicle>){



    fun addVehicle(vehicle: Vehicle): Boolean {
        val sizeVehicles = vehicles.size
        if (sizeVehicles > MAXIMUM_LENGTH_VEHICLES) return false
        else return vehicles.add(vehicle)
    }

    fun checkOutVehicle(plate: String){
        println(plate)
        var price: Int
        val vehicle: Vehicle? = vehicles.find { it.licensePlate == plate }
        vehicle?.let {
            price = ParkingSpace(vehicle).calculateFee()
        } ?: run { println("Vehículo no encontrado") }
        println(vehicle?.type?.price)
        println("Placa: ${vehicle?.licensePlate} el tiempo fue: ${vehicle?.parkedTime}")
    }
}
