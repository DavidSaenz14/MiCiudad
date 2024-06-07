package com.example.miciudad.data

import com.example.miciudad.model.Place
import com.example.miciudad.R
import com.example.miciudad.model.Category

object DataSource {
    val categories = listOf(
        Category(R.drawable.sport, R.string.sportFacilities),
        Category(R.drawable.park, R.string.parks),
        Category(R.drawable.restaurant, R.string.restaurants),
        Category(R.drawable.hotel, R.string.hotels)
    )

    val sportFacilities = listOf(
        Place(R.string.sport_facility1_name, R.string.sport_facility1_description, R.string.sportFacilities_address, R.drawable.sport),
        Place(R.string.sport_facility2_name, R.string.sport_facility2_description, R.string.sportFacilities_address, R.drawable.sport_facility2),
        Place(R.string.sport_facility3_name, R.string.sport_facility3_description, R.string.sportFacilities_address, R.drawable.sport_facility3)
    )

    val parks = listOf(
        Place(R.string.park1_name, R.string.park1_description, R.string.parks_address, R.drawable.park1),
        Place(R.string.park2_name, R.string.park2_description, R.string.parks_address, R.drawable.park2),
        Place(R.string.park3_name, R.string.park3_description, R.string.parks_address, R.drawable.park3)
    )

    val restaurants = listOf(
        Place(R.string.restaurant1_name, R.string.restaurant1_description, R.string.restaurants_address, R.drawable.restaurant1),
        Place(R.string.restaurant2_name, R.string.restaurant2_description, R.string.restaurants_address, R.drawable.restaurant2),
        Place(R.string.restaurant3_name, R.string.restaurant3_description, R.string.restaurants_address, R.drawable.restaurant3)
    )

    val hotels = listOf(
        Place(R.string.hotel1_name, R.string.hotel1_description, R.string.hotels_address, R.drawable.hotel1),
        Place(R.string.hotel2_name, R.string.hotel2_description, R.string.hotels_address, R.drawable.hotel2),
        Place(R.string.hotel3_name, R.string.hotel3_description, R.string.hotels_address, R.drawable.hotel3)
    )
}
