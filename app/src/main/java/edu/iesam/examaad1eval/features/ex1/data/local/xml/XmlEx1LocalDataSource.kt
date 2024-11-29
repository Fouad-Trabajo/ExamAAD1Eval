package edu.iesam.examaad1eval.features.ex1.data.local.xml

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.User

class XmlEx1LocalDataSource(private val context: Context) {

    private val gson = Gson()

    private val sharedPref

    fun saveUsers(users: List<User>) {

    }

    fun getUsers(): List<User> {
        return emptyList()
    }
}