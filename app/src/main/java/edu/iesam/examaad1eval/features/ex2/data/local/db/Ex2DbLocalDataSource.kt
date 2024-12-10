package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DbLocalDataSource(private val gameDao: GameDao) {

    fun saveAll(game: List<Game>) {
        gameDao.saveAll(*game.map { it.toEntity() }.toTypedArray())
    }
     fun getAll(): List<Game> {
        return gameDao.getAll().map { it.toDomain() }
    }

}