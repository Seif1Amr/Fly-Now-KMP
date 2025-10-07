package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import org.example.project.ui.screens.BookingConfirmationScreen
import org.example.project.ui.screens.FlightDetailsScreen
import org.example.project.ui.screens.FlightResultsScreen
import org.example.project.ui.screens.FlightSearchScreen
import org.example.project.viewmodel.FlightSearchViewModel
import org.example.project.viewmodel.NavigationState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = remember { FlightSearchViewModel() }
        val navState by viewModel.navigationState.collectAsState()

        when (val state = navState) {
            is NavigationState.Search -> {
                FlightSearchScreen(
                    onSearchClick = {
                        origin, destination, date, passengers ->
                        viewModel.searchFlights(origin, destination, date, passengers)
                    }
                )
            }
            is NavigationState.Results -> {
                FlightResultsScreen(
                    flights = state.flights,
                    onFlightClick = { flight -> viewModel.onFlightSelected(flight) },
                    onBackClick = { viewModel.onBackToSearch() }
                )
            }
            is NavigationState.Details -> {
                FlightDetailsScreen(
                    flight = state.flight,
                    onBookClick = { flight -> viewModel.onBookFlight(flight) },
                    onBackClick = { viewModel.onBackToResults() }
                )
            }
            is NavigationState.BookingConfirmation -> {
                BookingConfirmationScreen(
                    flight = state.flight,
                    onDoneClick = { viewModel.onBackToSearch() }
                )
            }
        }
    }
}
