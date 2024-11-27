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
            val userJson = gson.toJson(user)
            sharedPref.edit().putString(user.id, userJson).apply()
        }
    }


    fun saveAllItems(items: List<Item>) {
        items.forEach { item ->
            val itemJson = gson.toJson(item)
            sharedPref.edit().putString(item.id, itemJson).apply()
        }
    }

    fun saveAllServices(services: List<Services>) {
        services.forEach { service ->
            val serviceJson = gson.toJson(service)
            sharedPref.edit().putString(service.id, serviceJson).apply()
        }
    }


    fun getAllUsers(): List<User> {
        val users = mutableListOf<User>()
        val userKeys = sharedPref.getStringSet("user_keys", setOf())
        if (userKeys != null) {
            for (userKey in userKeys) {
                val userJson = sharedPref.getString(userKey, null)
                if (userJson != null) {
                    val user = gson.fromJson(userJson, User::class.java)
                    users.add(user)
                }
            }
        }
        return users
    }



    fun getAllItems(): List<Item> {
       val items = mutableListOf<Item>()
        val item = sharedPref.getStringSet("item_keys", setOf())
        if (item != null) {
            for (user in item) {
                val item = sharedPref.getString(user, null)
                if (item != null) {
                    val item = gson.fromJson(item, Item::class.java)
                    items.add(item)
                }
            }
        }
        return items
    }


    fun getAllServices(): List<Services> {
        val services = mutableListOf<Services>()
        val itemKeys = sharedPref.getStringSet("item_keys", setOf())
        if (itemKeys != null) {
            for (service in itemKeys) {
                val service = sharedPref.getString(service, null)
                if (service != null) {
                    val service = gson.fromJson(service, Services::class.java)
                    services.add(service)
                }
            }
        }
        return services
    }
}