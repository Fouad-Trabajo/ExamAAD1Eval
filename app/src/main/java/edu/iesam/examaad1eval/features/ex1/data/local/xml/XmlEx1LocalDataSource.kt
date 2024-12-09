package edu.iesam.examaad1eval.features.ex1.data.local.xml

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class XmlEx1LocalDataSource(private val context: Context) {

    private val gson = Gson()

    private val sharedPref =
        context.getSharedPreferences(
            context.getString(R.string.db_exam),
            Context.MODE_PRIVATE
        )
    private val editor = sharedPref.edit()


    fun saveUsers(users: List<User>) {
        val listUsers = gson.toJson(users)
        editor.putString("users", listUsers).commit()
    }

    fun getUsers(): List<User> {
        val listUsers = sharedPref.getString("users", null)
        val type = object : TypeToken<List<User>>() {}
        return if(listUsers != null){
            gson.fromJson(listUsers, type)
        }else{
            emptyList()
        }
    }

    fun saveItems(items: List<Item>) {
        val listItems = gson.toJson(items)
        editor.putString("items", listItems).apply()

    }

    fun getItems(): List<Item> {
        val listItems = sharedPref.getString("items", null)
        val type = object : TypeToken<List<Item>>() {}
        return if (listItems != null) {
            gson.fromJson(listItems, type)
        }else{
            emptyList()
        }
    }

    fun saveServices(services: List<Services>) {
        val listServices = gson.toJson(services)
        editor.putString("services", listServices).commit()

    }

    fun getServices(): List<Services> {
        val listServices = sharedPref.getString("services", null)
        val type = object : TypeToken<List<Services>>() {}

        return if (listServices != null) {
            gson.fromJson(listServices, type)
        } else {
            emptyList()
        }
    }
}