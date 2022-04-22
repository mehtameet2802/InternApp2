package com.example.intern

import androidx.lifecycle.LiveData

class UserRepository(private  val userDao:UserDao) {

    val readData :LiveData<List<TheProject>> = userDao.readData()

    suspend  fun addData(id:TheProject){
        userDao.addData(id)
    }

}