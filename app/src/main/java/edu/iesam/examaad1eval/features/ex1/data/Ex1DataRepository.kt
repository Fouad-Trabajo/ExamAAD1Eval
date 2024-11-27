package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.XmlEx1LocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val ex1RemoteDataSource: MockEx1RemoteDataSource,
    private val ex1LocalDataSource: XmlEx1LocalDataSource
) : Ex1Repository {


    override fun getUsers(): List<User> {
        val usersFromLocal = ex1LocalDataSource.getAllUsers()
        return if (usersFromLocal.isEmpty()) {
            val usersFromRemote = ex1RemoteDataSource.getUsers()
            ex1LocalDataSource.saveAllUsers(usersFromRemote)
            usersFromRemote
        } else{
            usersFromLocal
        }
    }

    override fun getItems(): List<Item> {
        val itemsFromLocal = ex1LocalDataSource.getAllItems()
        return if (itemsFromLocal.isEmpty()) {
            val itemsFromRemote = ex1RemoteDataSource.getItems()
            ex1LocalDataSource.saveAllItems(itemsFromRemote)
            itemsFromRemote
        } else{
            itemsFromLocal
        }
    }

    override fun getServices(): List<Services> {
        val servicesFromLocal = ex1LocalDataSource.getAllServices()
        return if (servicesFromLocal.isEmpty()) {
            val servicesFromRemote = ex1RemoteDataSource.getServices()
            ex1LocalDataSource.saveAllServices(servicesFromRemote)
            servicesFromRemote
        } else{
            servicesFromLocal
        }
    }
}