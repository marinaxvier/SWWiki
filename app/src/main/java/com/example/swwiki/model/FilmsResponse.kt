package com.example.swwiki.model


class FilmsResponse (
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: List<FilmsData>
)
