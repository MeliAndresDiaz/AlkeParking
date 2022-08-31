package com.bootcamp.alkeparking.data

/**
 * ¿Por que se define vehicles como un Set?
 * R: Dadas las condiciones del ejercicio al no poder repertise los datos la opcion mas adecuada
 * es utilizar el set
 */

data class Parking(val vehicles: MutableSet<Vehicle>)
