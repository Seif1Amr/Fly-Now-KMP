package org.example.project.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.models.Flight
import org.example.project.repository.FlightRepository
import org.example.project.repository.MockFlightRepository

// A simple ViewModel base class for KMP. In a real app, you might use a library like moko-mvvm.
// For now, we will manage the coroutine scope manually.
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

open class ViewModel {
    protected val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun clear() {
        viewModelScope.cancel()
    }
}

// Represents the different screens/states of our navigation
sealed interface NavigationState {
    object Search : NavigationState
    data class Results(val flights: List<Flight>) : NavigationState
    data class Details(val flight: Flight, val previousResults: List<Flight>) : NavigationState
    data class BookingConfirmation(val flight: Flight) : NavigationState
}

class FlightSearchViewModel(private val flightRepository: FlightRepository = MockFlightRepository()) : ViewModel() {

    private val _navigationState = MutableStateFlow<NavigationState>(NavigationState.Search)
    val navigationState: StateFlow<NavigationState> = _navigationState.asStateFlow()

    fun searchFlights(origin: String, destination: String, date: String, passengers: Int) {
        viewModelScope.launch {
            val flights = flightRepository.searchFlights(origin, destination, date, passengers)
            _navigationState.value = NavigationState.Results(flights)
        }
    }

    fun onFlightSelected(flight: Flight) {
        val currentState = _navigationState.value
        if (currentState is NavigationState.Results) {
            _navigationState.value = NavigationState.Details(flight, currentState.flights)
        }
    }

    fun onBookFlight(flight: Flight) {
        // In a real app, you would perform the booking logic here.
        _navigationState.value = NavigationState.BookingConfirmation(flight)
    }

    fun onBackToResults() {
        val currentState = _navigationState.value
        if (currentState is NavigationState.Details) {
            _navigationState.value = NavigationState.Results(currentState.previousResults)
        }
    }

    fun onBackToSearch() {
        _navigationState.value = NavigationState.Search
    }
}
