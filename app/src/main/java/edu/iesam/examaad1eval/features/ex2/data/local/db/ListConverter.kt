package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player


class ListConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToList(value: String): List<Player> {
        return gson.fromJson(value, object : TypeToken<List<Player>>() {}.type)
    }

    @TypeConverter
    fun listToString(value: List<Player>): String {
        return gson.toJson(value)
    }
}

