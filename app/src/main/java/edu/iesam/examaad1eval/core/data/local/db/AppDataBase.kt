package edu.iesam.examaad1eval.core.data.local.db

import androidx.room.Database
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerConverter
import edu.iesam.examaad1eval.features.ex2.domain.Game

@Database(entities = [Game::class], version = 1)
@TypeConverters(PlayerConverter::class)
abstract class AppDataBase {

    abstract fun gameDao(): GameDao
}