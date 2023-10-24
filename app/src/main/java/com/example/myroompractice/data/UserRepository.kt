package com.example.myroompractice.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao:UserDao) {
    val readAllDate:LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user:User){
                userDao.addUser(user)
            }
}