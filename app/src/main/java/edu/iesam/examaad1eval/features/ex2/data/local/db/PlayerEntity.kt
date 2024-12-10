package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "player")
class PlayerEntity(
    @PrimaryKey @ColumnInfo(name ="id") val id: String,
    @ColumnInfo (name ="name") val name: String
)