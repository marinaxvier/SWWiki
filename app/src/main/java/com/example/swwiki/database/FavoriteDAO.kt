package com.example.swwiki.database

import androidx.room.*
import com.example.swwiki.model.Favorite

@Dao
interface FavoriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites ORDER BY id ASC")
    suspend fun getAllFavorites(): List<Favorite>

    @Delete
    suspend fun removeFavorite(favorite: Favorite)
}