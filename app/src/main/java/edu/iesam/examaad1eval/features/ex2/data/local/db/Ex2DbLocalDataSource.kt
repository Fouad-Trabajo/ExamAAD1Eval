package edu.iesam.examaad1eval.features.ex2.data.local.db

class Ex2DbLocalDataSource(private val gameDao: GameDao) {

    fun saveGames(games : List<Game>) {
        //gameDao.insertAll(*games.toTypedArray())
    }

    fun getGames(): List<Game> {
        return emptyList()
    }
}