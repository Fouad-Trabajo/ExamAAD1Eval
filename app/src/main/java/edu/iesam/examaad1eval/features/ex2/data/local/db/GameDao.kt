package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import edu.iesam.examaad1eval.features.ex2.domain.Game

@Dao
interface GameDao {

        @Query("SELECT * FROM game")
        fun getAll(): List<Game>

        @Insert
        fun insertAll(vararg games: Game)

}