package com.example.swwiki.model

import com.google.gson.annotations.SerializedName

data class PlanetData (
    val name: String,
    @SerializedName ("rotation_period") val rotationPeriod: String,
    @SerializedName ("orbital_period") val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @SerializedName ("surface_water") val surfaceWater: String,
    val population: String,
    val url: String
)