package com.example.swwiki.model

data class PlanetsResponse(
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: List<PlanetData>
)