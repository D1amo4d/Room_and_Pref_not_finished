package com.example.jojo1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey val uid:Int?=null,
   @ColumnInfo(name = "first_name") val title: String? = null,
   @ColumnInfo(name = "last_name") val desc: String? = null,
) : Serializable