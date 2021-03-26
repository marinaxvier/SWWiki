package com.example.swwiki.model

data class SpeciesResponse (
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: List<SpeciesData>
)