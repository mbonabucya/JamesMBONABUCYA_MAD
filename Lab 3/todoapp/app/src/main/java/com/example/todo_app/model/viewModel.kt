package com.example.todo_app.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewModel:ViewModel() {
     private var _todoItem = MutableLiveData(listOf<datamodel>())
    val todoItem:LiveData<List<datamodel>> = _todoItem


    fun additem(item :datamodel)
    {
        _todoItem.value = _todoItem.value!!+ listOf(item)
    }
    fun deleteItem(item:datamodel)
    {
        _todoItem.value = _todoItem.value!!.toMutableList().also {
            it.remove(item)
        }
    }
}