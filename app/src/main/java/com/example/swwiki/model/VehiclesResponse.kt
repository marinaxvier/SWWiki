package com.example.swwiki.model


class VehiclesResponse(
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: List<VehiclesData>
)