package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.xml.XmlEx1LocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val mockEx1RemoteDataSource: MockEx1RemoteDataSource,
    private val xmlEx1LocalDataSource: XmlEx1LocalDataSource
) : Ex1Repository {


    override fun getUsers(): List<User> {
        val usersFromLocal = xmlEx1LocalDataSource.getUsers()
        return if (usersFromLocal.isEmpty()) {
            val usersFromRemote = mockEx1RemoteDataSource.getUsers()
            xmlEx1LocalDataSource.saveUsers(usersFromRemote)
            usersFromRemote
        } else{
            usersFromLocal
        }
    }

    override fun getItems(): List<Item> {
        val itemsFromLocal = xmlEx1LocalDataSource.getItems()
        return if (itemsFromLocal.isEmpty()) {
            val itemsFromRemote = mockEx1RemoteDataSource.getItems()
            xmlEx1LocalDataSource.saveItems(itemsFromRemote)
            itemsFromRemote
        } else{
            itemsFromLocal
        }
    }

    override fun getServices(): List<Services> {
        val servicesFromLocal = xmlEx1LocalDataSource.getServices()
        return if (servicesFromLocal.isEmpty()) {
            val servicesFromRemote = mockEx1RemoteDataSource.getServices()
            xmlEx1LocalDataSource.saveServices(servicesFromRemote)
            servicesFromRemote
        } else{
            servicesFromLocal
        }
    }
}