package com.bootcamp.alkeparking.data

data class Vehicle(var licensePlate: String) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.licensePlate == other.licensePlate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.licensePlate.hashCode()
}
