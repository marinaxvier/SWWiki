package com.example.swwiki.model

import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("uid") var id: String,
    var name: String,
    var url: String
)