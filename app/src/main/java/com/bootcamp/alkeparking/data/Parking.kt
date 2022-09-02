package com.bootcamp.alkeparking.data

import com.bootcamp.alkeparking.utils.AlkerParkingConstants

/**
 * ¿Por que se define vehicles como un Set?
 * R: Dadas las condiciones del ejercicio al no poder repertise los datos la opcion mas adecuada
 * es utilizar el set
 */

data class Parking(val vehicles: MutableSet<Vehicle>, var profits: Pair<Int, Int>) {

    //var vehiclesremove: Pair<Int,Int> = Pair(0,0)

    //method to add vehicles, if added returns true else false xd
    fun addVehicle(vehicle: Vehicle): String {
        return with(vehicles) {
            when {
                vehicles.size == AlkerParkingConstants.MAXIMUM_LENGTH_VEHICLES -> "Sorry, the has check-in failed"
                add(vehicle) -> "Welcome to AlkeParking!"
                else -> {
                    "Sorry, the has check-in failed"
                }
            }
        }
    }

    fun removeVehicle(vehicle: Vehicle) {
        vehicles.remove(vehicle)
    }

    fun searchvehicle(plate: String): Vehicle? {
        return vehicles.find { it.licensePlate == plate }
    }

    fun totalListVehicles(){
        println("\nList of registered vehicles")
        vehicles.forEach { print("${it.licensePlate}\n") }
    }

    fun saveEarnings(p1: Int, p2: Int){
        println("$p1 vehicles have checked out and have earnings of $p2")
    }

   /* fun saveEarnings(vehiclesremove: Pair<Int,Int>){
        this.vehiclesremove = this.vehiclesremove.copy(first = vehiclesremove.first, second = vehiclesremove.second)
        println("${vehiclesremove.first} vehicles have checked out and have earnings of ${vehiclesremove.second}")

    }*/
}
