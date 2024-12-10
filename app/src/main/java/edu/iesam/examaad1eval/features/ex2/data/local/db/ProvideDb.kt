package edu.iesam.examaad1eval.features.ex2.data.local.db

import android.content.Context
import androidx.room.Room

class ProvideDb {

    fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-exam"
        ).build()
    }
}