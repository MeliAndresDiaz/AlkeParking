package com.bootcamp.alkeparking.data

import com.bootcamp.alkeparking.utils.VehicleType
import java.util.*

data class Vehicle(
    var licensePlate: String,
    var type: VehicleType,
    var date: Calendar,
    var discountCard: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.licensePlate == other.licensePlate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.licensePlate.hashCode()
}
