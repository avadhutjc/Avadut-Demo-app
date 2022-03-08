package com.ajc.avadhut_demo_app.model.local


//Installed pojo generator...plugin by author dnet

import androidx.room.*
import kotlinx.coroutines.selects.select

@Dao
interface LoginDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(loginEntity: LoginEntity) //loginEntity is object and LoginEntity is table

    @Query("select * from login_table where email = :email and password = :password")
    fun getUser(email: String, password: String): LoginEntity

    @Update
    fun updateUser(loginEntity: LoginEntity)

    @Delete
    fun deleteUser(loginEntity: LoginEntity)


}