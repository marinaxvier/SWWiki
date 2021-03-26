package com.example.swwiki.model

import com.google.gson.annotations.SerializedName

data class FilmsData(
    var title: String,
    @SerializedName("episode_id") var episodeNumber: String,
    @SerializedName("opening_crawl") var openingCrawl: String,
    var director: String,
    var producer: String,
    @SerializedName("release_date") var releaseDate: String,
    var url: String
)