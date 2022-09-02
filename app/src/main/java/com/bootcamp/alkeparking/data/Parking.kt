package com.bootcamp.alkeparking.data

import com.bootcamp.alkeparking.utils.AlkeParkingConstants

/**
 * ¿Por que se define vehicles como un Set?
 * R: Dadas las condiciones del ejercicio al no poder repertise los datos la opcion mas adecuada
 * es utilizar el set
 */

data class Parking(val vehicles: MutableSet<Vehicle>, var profits: Pair<Int, Int>) {

    /**
     * 1. Method addVehicle() return true or false according to the result of the process
     * 2. Method removeVehicle() search the licensePlate on the set and removes the vehicle
     * 3. Method searchVehicle() is used to search a licensePlate within the set and calculate the
     *    amount of parking fees to be paid
     * 4. Method saveEarnings() show the earnings and the total of vehicles go out
     */

    fun addVehicle(vehicle: Vehicle): String {
        return with(vehicles) {
            when {
                vehicles.size == AlkeParkingConstants.MAXIMUM_LENGTH_VEHICLES -> "Sorry, the parking is full"
                add(vehicle) -> "Welcome to AlkeParking!"
                else -> {
                    "Sorry, the has check-in failed"
                }
            }
        }
    }

    fun removeVehicle(vehicle: Vehicle) {
        val parkingSpace =  ParkingSpace(vehicle)
        parkingSpace.checkOutVehicle(vehicle.licensePlate)
        vehicles.remove(vehicle)
    }

    fun searchVehicle(plate: String): Vehicle? {
        return vehicles.find { it.licensePlate == plate }
    }

    fun totalListVehicles(){
        println("\nList of registered vehicles")
        vehicles.forEach { print("${it.licensePlate}\n") }
    }

    fun saveEarnings(profits: Pair<Int,Int>){
        println("${profits.first} vehicles have checked out and have earnings of ${profits.second}")
    }
}
