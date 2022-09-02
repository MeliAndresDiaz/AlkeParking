package com.bootcamp.alkeparking.data

import java.util.*
import com.bootcamp.alkeparking.utils.AlkeParkingConstants.DISCOUNT_PERCENTAGE
import com.bootcamp.alkeparking.utils.AlkeParkingConstants.EXTRA_FEE
import com.bootcamp.alkeparking.utils.AlkeParkingConstants.INITIAL_TIME_MINUTES
import com.bootcamp.alkeparking.utils.AlkeParkingConstants.MINUTES_IN_MILLISECONDS
import com.bootcamp.alkeparking.utils.AlkeParkingConstants.QUARTER_HOUR
import com.bootcamp.alkeparking.utils.VehicleType
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle) {

    /**
     * 1. The variables countVehicle and totalEarnings represent the number of vehicles withdraw and
     *    the total earnings.
     * 2. The val parking is an instance of the data class Parking()
     * 3. 1. Method checkOutVehicle() search a vehicle with the function searchVehicle(), with result
     *    the fee is calculate, also with function removeVehicle() the vehicle is remove on the set
     * 4. The val parkedTime represents the amount of time the vehicle was parking
     * 5. Method checkOutVehicle() search a vehicle with the function searchVehicle(), with result
     *    the fee is calculate, also with function removeVehicle() the vehicle is remove on the set
     * 6. Functions onSuccess and onError are used on the method checkOutVehicle for print result
     * 7. Function hasDiscountCard is used to return a value that can be true or false
     * 8. Method calculateFee() calculate the total amount to be paid for the vehicle
     * 9. Functions getFeeWithoutExtraTime and getFeeWithExtraTime() calculate the fee in both cases
     */

    private var countVehicle: Int = 0
    private var totalEarning: Int = 0
    private var randomType = (120..300)

    private val parking = Parking(mutableSetOf(vehicle), Pair(countVehicle, totalEarning))

    private val parkedTime: Long
        get() = ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS) + randomType.random()

    fun checkOutVehicle(plate: String) {
        parking.searchVehicle(plate)?.let {
            val earning = calculateFee(
                it.type,
                parkedTime.toInt(),
                hasDiscountCard(it.discountCard)
            )
            onSuccess(earning)
            countVehicle++
            totalEarning += earning
            parking.profits = Pair(countVehicle, totalEarning)
            parking.saveEarnings(parking.profits)
        } ?: onError()
    }

    private fun onSuccess(totalAmount: Int) {
        println("\nYour fee is $totalAmount, Come back soon")
    }

    private fun onError() {
        println("Sorry, the check-out failed")
    }

    private fun hasDiscountCard(discount: String?): Boolean {
        return discount.isNullOrEmpty().not()
    }

    private fun calculateFee(
        vehicleType: VehicleType,
        parkedTime: Int,
        hasDiscountCard: Boolean
    ): Int {
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

    private fun getFeeWithoutExtraTime(fee: Int, hasDiscountCard: Boolean): Int {
        if (hasDiscountCard) {
            return (fee - (fee * DISCOUNT_PERCENTAGE)).toInt()
        }
        return fee
    }

    private fun getFeeWithExtraTime(fee: Int, hasDiscountCard: Boolean): Int {
        val newTime = ceil(((parkedTime - INITIAL_TIME_MINUTES) / QUARTER_HOUR).toDouble())
        val feeExtra = fee + (newTime * EXTRA_FEE)

        if (hasDiscountCard) {
            return (feeExtra - (feeExtra * DISCOUNT_PERCENTAGE)).toInt()
        }
        return feeExtra.toInt()
    }
}
