package org.example.project.models

import kotlinx.serialization.Serializable

@Serializable
data class Booking(
    val id: String,
    val userId: String,
    val flightId: String,
    val bookingDate: String,
    val numberOfPassengers: Int,
    val totalPrice: Double
)
