package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(private val ex2LocalDataSource: Ex2DbLocalDataSource) : Ex2Repository {


    override fun getGames(): List<Game> {
        val gamesFromDbLocal = ex2LocalDataSource.getGames()
        return emptyList()
    }
}