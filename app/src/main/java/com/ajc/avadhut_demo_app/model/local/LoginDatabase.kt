package com.ajc.avadhut_demo_app.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LoginEntity::class], version = 1) //your roomdb should know that how many tables you are going to create
abstract class LoginDatabase : RoomDatabase() {

    abstract fun getLoginDAO(): LoginDAO //we are making abstract class so it can provide DAO obj

    companion object {
        private var instance: LoginDatabase? = null
        fun getLoginDatabase(context: Context): LoginDatabase {
            if (instance != null) {
                return instance!! //it is checking if it is already created then return
            } else {  //if not created we are creating obj
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    LoginDatabase::class.java,
                    "logindb"
                )
                builder.fallbackToDestructiveMigration()//if old db changes to new db then we need to implement or whenever data schema changes we need to upgrade version to latest version
                instance = builder.build()
            }
            return instance!!
        }
    }
}