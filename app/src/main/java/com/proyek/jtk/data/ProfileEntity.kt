package com.proyek.jtk.data

//class ProfileEntity {
//}

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val photoUri: String? = null  // Menyimpan URI foto sebagai String
)
