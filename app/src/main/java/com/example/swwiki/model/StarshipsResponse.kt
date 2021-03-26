package com.example.swwiki.model

data class StarshipsResponse(
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: List<StarshipsData>
)