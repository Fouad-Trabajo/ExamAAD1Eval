package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player

class PlayerConverter {

    private  val gson = Gson()


    @TypeConverters
    fun fromPlayerList(players: List<Player>): String {
        return gson.toJson(players)
    }

    @TypeConverters
    fun toPlayerList(json: String): List<Player> {
        val type = object : TypeToken<List<Player>>() {}.type
        return gson.fromJson(json, type)
    }
}