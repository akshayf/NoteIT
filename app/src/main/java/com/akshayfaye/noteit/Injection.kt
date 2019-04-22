package com.akshayfaye.noteit

import android.content.Context
import com.akshayfaye.noteit.database.NoteDao
import com.akshayfaye.noteit.database.NoteDatabase

object Injection {

    private fun provideUserDataSource(context: Context): NoteDao {
        val database = NoteDatabase(context)
        return database.noteDao()
    }

    fun provideViewModelFactory(context: Context): NoteViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return NoteViewModelFactory(dataSource)
    }
}