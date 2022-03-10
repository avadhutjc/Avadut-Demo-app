package com.ajc.avadhut_demo_app.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun getLoginDAO(): LoginDAO

    companion object {
        private var instance: LoginDatabase? = null
        fun getLoginDatabase(context: Context): LoginDatabase {
            if (instance != null) {
                return instance!!
            } else {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    LoginDatabase::class.java,
                    "login_db"
                )
                builder.fallbackToDestructiveMigration()
                instance = builder.build()
            }
            return instance!!
        }
    }
}