package org.example.project.models

import kotlinx.serialization.Serializable

@Serializable
data class Flight(
    val id: String,
    val airline: String,
    val flightNumber: String,
    val origin: Airport,
    val destination: Airport,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val price: Double
)

@Serializable
data class Airport(
    val code: String,
    val name: String,
    val city: String
)
