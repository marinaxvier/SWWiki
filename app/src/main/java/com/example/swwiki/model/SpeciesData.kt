package com.example.swwiki.model

import com.google.gson.annotations.SerializedName

data class SpeciesData (
    var name: String,
    var classification: String,
    var designation: String,
    @SerializedName("average_height") var averageHeight: String,
    @SerializedName("skin_colors") var skinColors: String,
    @SerializedName("hair_colors") var hairColors: String,
    @SerializedName ("eye_colors") var eyeColors: String,
    @SerializedName("average_lifespan") var averageLifeSpan: String,
    var language: String,
    var url: String
)