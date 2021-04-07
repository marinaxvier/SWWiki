package com.example.swwiki.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorites")
data class Favorite (
    @PrimaryKey val id: String,
    val name: String,
    val url: String,
    val type: String
): Serializable