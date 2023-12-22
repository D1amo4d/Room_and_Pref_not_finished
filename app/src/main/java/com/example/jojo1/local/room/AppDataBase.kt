package com.example.jojo1.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jojo1.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): TaskDao

}