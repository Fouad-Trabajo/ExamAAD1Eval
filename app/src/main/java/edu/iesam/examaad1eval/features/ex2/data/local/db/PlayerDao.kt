package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayers(vararg player: PlayerEntity)

    @Query("SELECT * FROM player")
    fun getPlayers(): List<PlayerEntity>

}