package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val mockEx2RemoteDataSource: MockEx2RemoteDataSource,
    private val ex2DbLocalDataSource: Ex2DbLocalDataSource
) : Ex2Repository {

    override fun getGames(): List<Game> {
        val gamesFromLocal = ex2DbLocalDataSource.getAll()
        return if (gamesFromLocal.isEmpty()) {
            val gamesFromRemote = mockEx2RemoteDataSource.getGames()
            ex2DbLocalDataSource.saveAll(gamesFromRemote)
            gamesFromRemote
        } else {
            gamesFromLocal
        }
    }

    fun saveAll(games: List<Game>) {
        ex2DbLocalDataSource.saveAll(games)
    }

}