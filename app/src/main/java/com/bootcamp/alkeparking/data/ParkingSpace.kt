package com.bootcamp.alkeparking.data

import java.util.*
import com.bootcamp.alkeparking.utils.AlkerParkingConstants
import com.bootcamp.alkeparking.utils.AlkerParkingConstants.DISCOUNT_PERCENTAGE
import com.bootcamp.alkeparking.utils.AlkerParkingConstants.EXTRA_FEE
import com.bootcamp.alkeparking.utils.AlkerParkingConstants.INITIAL_TIME_MINUTES
import com.bootcamp.alkeparking.utils.AlkerParkingConstants.MINUTES_IN_MILISECONDS
import com.bootcamp.alkeparking.utils.AlkerParkingConstants.QUARTER_HOUR
import com.bootcamp.alkeparking.utils.VehicleType

data class ParkingSpace(var vehicle: Vehicle) {

    private var countVehicle: Int = 0
    var totalEarning: Int = 0

    private val parking = Parking(mutableSetOf(vehicle), Pair(countVehicle,totalEarning))

    private val parkedTime: Long
        get() = ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS) + 185

    fun checkOutVehicle(plate: String) {
        parking.searchvehicle(plate)?.let {
            val earning = calculateFee(
                it.type,
                parkedTime.toInt(),
                hasDiscountCard(it.discountCard)
            )
            onSuccess(earning)
            parking.removeVehicle(it)
            countVehicle++
            totalEarning += earning
            parking.saveEarnings(countVehicle,totalEarning)
        } ?: onError()
    }

    //function that shows the ok if the checkout was correct
    private fun onSuccess(totalAmount: Int) {
        println("Your fee is $totalAmount, Come back soon")
    }

    private fun onError() {
        println("Sorry, the check-out failed")
    }

    private fun hasDiscountCard(discount: String?): Boolean {
        return discount.isNullOrEmpty().not()
    }

    fun calculateFee(vehicleType: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        return when {
            parkedTime <= INITIAL_TIME_MINUTES -> getFeeWithoutExtraTime(
                vehicleType.price,
                hasDiscountCard
            )
            parkedTime > INITIAL_TIME_MINUTES -> getFeeWithExtraTime(
                vehicleType.price,
                hasDiscountCard
            )
            else -> {
                0
            }
        }
    }

    fun getFeeWithoutExtraTime(fee: Int, hasDiscountCard: Boolean): Int {
        if (hasDiscountCard) {
            return (fee - (fee * DISCOUNT_PERCENTAGE)).toInt()
        }
        return fee
    }

    fun getFeeWithExtraTime(fee: Int, hasDiscountCard: Boolean): Int {
        val newTime = Math.ceil(((parkedTime - INITIAL_TIME_MINUTES) / QUARTER_HOUR).toDouble())
        val feeExtra = fee + (newTime * EXTRA_FEE)

        if (hasDiscountCard) {
            return (feeExtra - (feeExtra * DISCOUNT_PERCENTAGE)).toInt()
        }
        return feeExtra.toInt()
    }
}
