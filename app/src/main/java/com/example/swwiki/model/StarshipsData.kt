package com.example.swwiki.model

import com.google.gson.annotations.SerializedName

class StarshipsData(
    var name: String,
    var model: String,
    var length: String,
    @SerializedName("max_atmosphering_speed") var maxAtmospheringSpeed: String,
    var passengers: String,
    @SerializedName("cargo_capacity") var cargoCapacity: String,
    var url: String
)
