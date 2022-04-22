package com.example.intern

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application:Application): AndroidViewModel(application) {

    val readData:LiveData<List<TheProject>>
    private val repository:UserRepository
    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readData = repository.readData
    }

    fun add(id:TheProject){
        viewModelScope.launch(Dispatchers.IO){
            repository.addData(id)
        }
    }


}