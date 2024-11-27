package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context

import androidx.core.content.ContextCompat.getString
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class XmlEx1LocalDataSource(private val context: Context) {

    private val gson = Gson()

    val sharedPref = context.getSharedPreferences(
        getString(context, R.string.local_file_xml), Context.MODE_PRIVATE
    )


    fun saveAllUsers(users: List<User>) {
        users.forEach { user ->
            sharedPref.edit().putString(user.id, user.name).apply()
        }
    }


    fun saveAllItems(items: List<Item>) {
        items.forEach { item ->
            sharedPref.edit().putString(item.id, item.name).apply()
        }
    }

    fun saveAllServices(services: List<Services>) {
        services.forEach { service ->
            sharedPref.edit().putString(service.id, service.name).apply()
        }
    }


    fun getAllUsers(): List<User> {
        val users = mutableListOf<User>()
        return users
    }

    fun getAllItems(): List<Item> {
        val items = mutableListOf<Item>()
        return items
    }


    fun getAllServices(): List<Services> {
        val services = mutableListOf<Services>()
        return services
    }
}