package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.xml.XmlEx1LocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        val ex1DataRepository = Ex1DataRepository(
            mockEx1RemoteDataSource = MockEx1RemoteDataSource(),
            xmlEx1LocalDataSource = XmlEx1LocalDataSource(this)
        )
        ex1DataRepository.getUsers()
        ex1DataRepository.getItems()
        ex1DataRepository.getServices()
        Log.d("@dev", ex1DataRepository.getUsers().toString())
        Log.d("@dev", ex1DataRepository.getItems().toString())
        Log.d("@dev", ex1DataRepository.getServices().toString())

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
        }
    }
}