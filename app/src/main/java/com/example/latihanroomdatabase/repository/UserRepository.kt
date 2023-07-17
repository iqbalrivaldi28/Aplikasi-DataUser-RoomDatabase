package com.example.latihanroomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.latihanroomdatabase.data.User
import com.example.latihanroomdatabase.data.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}