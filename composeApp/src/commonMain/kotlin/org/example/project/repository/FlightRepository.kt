package org.example.project.repository

import org.example.project.models.Flight

interface FlightRepository {
    suspend fun searchFlights(origin: String, destination: String, date: String, passengers: Int): List<Flight>
}

class MockFlightRepository : FlightRepository {
    override suspend fun searchFlights(origin: String, destination: String, date: String, passengers: Int): List<Flight> {
        // For now, return a static list of flights for UI development.
        // We will replace this with a real Ktor API call later.
        return listOf(
            Flight(
                id = "1",
                airline = "KMP Airways",
                flightNumber = "KA-2024",
                origin = org.example.project.models.Airport("CAI", "Cairo International Airport", "Cairo"),
                destination = org.example.project.models.Airport("JFK", "John F. Kennedy International Airport", "New York"),
                departureTime = "2024-08-15T10:00:00Z",
                arrivalTime = "2024-08-15T18:00:00Z",
                duration = "8h 00m",
                price = 750.00
            ),
            Flight(
                id = "2",
                airline = "Compose Jet",
                flightNumber = "CJ-101",
                origin = org.example.project.models.Airport("CAI", "Cairo International Airport", "Cairo"),
                destination = org.example.project.models.Airport("DXB", "Dubai International Airport", "Dubai"),
                departureTime = "2024-08-15T12:30:00Z",
                arrivalTime = "2024-08-15T16:00:00Z",
                duration = "3h 30m",
                price = 320.00
            )
        )
    }
}
