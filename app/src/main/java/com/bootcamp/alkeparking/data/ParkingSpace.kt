package com.bootcamp.alkeparking.data

import com.bootcamp.alkeparking.utils.AlkerParkingConstants

data class ParkingSpace(var vehicle: Vehicle){

    fun calculateFee(): Int{
        val time = (vehicle.parkedTime * AlkerParkingConstants.MINUTES_IN_MILISECONDS)
        val minFee = vehicle.type.price
        var discount = false
        vehicle.discountCard?.let { discount = true }
        if(time <= AlkerParkingConstants.INITIAL_TIME){
            if(discount) {
                return (minFee - (minFee * 0.15)).toInt()
            }
            return minFee
        }
        else{
            val newTime  = ((time - AlkerParkingConstants.INITIAL_TIME) / 15).toInt()
            val price = minFee + (newTime*5)
            if(discount) {
                return (price - (price*0.15)).toInt()
            }
            return price
        }
    }
}
