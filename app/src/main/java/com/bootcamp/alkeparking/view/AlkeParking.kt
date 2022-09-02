package com.bootcamp.alkeparking.view

import com.bootcamp.alkeparking.data.Parking
import com.bootcamp.alkeparking.data.ParkingSpace
import com.bootcamp.alkeparking.data.Vehicle
import com.bootcamp.alkeparking.utils.*
import java.util.*

fun main() {

    /**
     * 1. Vehicle entries are created on the set
     * 2. Variable listVehicleRegister() sets the vehicles on the array
     * 3. Variable parking is the instance of Parking data class
     * 4. In line 43 is used for show the entrie of the error on addVehicle()
     * 5. The lines 46 and 47 are used to test checkOutVehicle()
     */

    val auto = Vehicle("AAA34123", VehicleType.Car, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val bus = Vehicle("AAA341223", VehicleType.Bus, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val minibus = Vehicle("AAA341663", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus2 = Vehicle("AASS8884", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus3 = Vehicle("AASS8881", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus4 = Vehicle("AASS8882", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus5 = Vehicle("AASS8788", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus6 = Vehicle("AASS8888", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus7 = Vehicle("AASS8828", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus8 = Vehicle("AASS8878", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")//MISMA PLACA
    val bus9 = Vehicle("AASS8878", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")//MISMA PLACA
    val bus10 = Vehicle("AASS87888", VehicleType.MiniBus, Calendar.getInstance(),)
    val bus11 = Vehicle("AASS88788", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus12 = Vehicle("AASS8898", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus13 = Vehicle("AASS889/98", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus14 = Vehicle("AASS88/98", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus15 = Vehicle("AASS85388", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus16 = Vehicle("AASS887788", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus17 = Vehicle("AASS885248", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus18 = Vehicle("AASS883788", VehicleType.MiniBus, Calendar.getInstance(),"DISCOUNT_CARD_002")
    val bus19 = Vehicle("AASS883788", VehicleType.MiniBus, Calendar.getInstance(), "DISCOUNT_CARD_002") //CARRO NUMERO 21


    val listVehiclesRegister = arrayOf(auto,bus,minibus,bus2,bus3,bus4,bus5,bus6,bus7,bus8,bus9,bus10,bus11,bus12,bus13,bus14,bus15,bus16,bus17,bus18,bus19)
    val parking = Parking(mutableSetOf(), Pair(0,0))
    listVehiclesRegister.forEach { print("${parking.addVehicle(it)}\n")}

    val listVehiclesRegister2 = arrayOf(auto,bus)
    listVehiclesRegister2.forEach { ParkingSpace(it).checkOutVehicle(it.licensePlate) }
}