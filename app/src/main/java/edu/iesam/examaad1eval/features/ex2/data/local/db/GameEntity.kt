package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.domain.Player

@Entity
data class Game(
    @PrimaryKey @ColumnInfo val id: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @Embedded(prefix = "player") val player: Player
)