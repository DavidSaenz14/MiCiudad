package com.example.miciudad

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.miciudad.data.DataSource
import com.example.miciudad.model.Place
import com.example.miciudad.ui.ui.DetailedPlaceScreen
import com.example.miciudad.ui.ui.MyCityAppBar
import com.example.miciudad.ui.ui.MyCityViewModel
import com.example.miciudad.ui.ui.SelectCategoryScreen
import com.example.miciudad.ui.ui.SelectPlaceScreen

enum class MyCityScreen {
    Categories, Places, DetailPlace
}

// Definir la función navigateToStart
fun NavController.navigateToStart() {
    val navGraph = this.graph
    this.navigate(MyCityScreen.Categories.name) {
        popUpTo(navGraph.startDestinationId) { inclusive = true }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {

    val navController: NavHostController = rememberNavController()

    val viewModel: MyCityViewModel = viewModel()

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen =
        MyCityScreen.valueOf(backStackEntry?.destination?.route ?: MyCityScreen.Categories.name)

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(topBar = {
        MyCityAppBar(
            currentScreen = currentScreen.name,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() },
            uiState = uiState
        )

    }) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MyCityScreen.Categories.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MyCityScreen.Categories.name) {
                SelectCategoryScreen(
                    categories = DataSource.categories,
                    modifier = Modifier.fillMaxSize(),
                    onClicked= {
                        viewModel.updateCategory(it)
                        navController.navigate(MyCityScreen.Places.name)
                    },
                )
            }
            composable(MyCityScreen.Places.name) {
                val placeOptions = when (uiState.category) {
                    R.string.sportFacilities -> DataSource.sportFacilities
                    R.string.parks -> DataSource.parks
                    R.string.restaurants -> DataSource.restaurants
                    R.string.hotels -> DataSource.hotels
                    else -> DataSource.parks
                }
                SelectPlaceScreen(
                    places = placeOptions,
                    modifier = Modifier.fillMaxSize(),
                    onClicked = {
                        viewModel.updatePlace(it)
                        navController.navigate(MyCityScreen.DetailPlace.name)
                    },
                )
            }
            composable(MyCityScreen.DetailPlace.name) {
                val placeOptions = when (uiState.category) {
                    R.string.sportFacilities -> DataSource.sportFacilities
                    R.string.parks -> DataSource.parks
                    R.string.restaurants -> DataSource.restaurants
                    R.string.hotels -> DataSource.hotels
                    else -> DataSource.parks
                }
                val place: Place =
                    placeOptions.find { it.nameResourceId == uiState.place }
                        ?: DataSource.parks[0]
                DetailedPlaceScreen(
                    modifier = Modifier,
                    onBackButtonClicked = { navController.navigateToStart() },
                    place
                )
            }
        }
    }
}
