package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.db.AppDatabase
import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.local.db.ProvideDb
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        lifecycleScope.launch {

            val db = ProvideDb().provideDb(applicationContext)
            val ex2DataRepository = Ex2DataRepository(
                mockEx2RemoteDataSource = MockEx2RemoteDataSource(),
                ex2DbLocalDataSource = Ex2DbLocalDataSource(db.gameDao())
            )
            val games = withContext(Dispatchers.IO) { ex2DataRepository.getGames() }
            withContext(Dispatchers.IO) { ex2DataRepository.saveAll(games) }
        }
    }
}