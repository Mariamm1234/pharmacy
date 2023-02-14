package com.example.pharmacy.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = [customer::class,admin::class,logedin::class,medicine::class], version = 1)
abstract class database:RoomDatabase() {
   abstract fun getDao():DAO
   companion object{
       val Database="appdata"
       @Volatile
    private var instance:database?=null
       private var Lock=Any()
       operator fun invoke(context:Context)= instance?: synchronized(Lock){
           instance ?: buildDatabase(context).also{
              instance = it
           }
       }

       private fun buildDatabase(context:Context)= Room.databaseBuilder(context,
       database::class.java, Database
           ).allowMainThreadQueries()
           .build()
   }

}