package com.akshayfaye.noteit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshayfaye.noteit.database.NoteDao

class NoteViewModelFactory(private val dataSource: NoteDao) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}