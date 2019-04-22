package com.akshayfaye.noteit

import androidx.lifecycle.ViewModel;
import com.akshayfaye.noteit.database.NoteDao
import io.reactivex.Completable
import io.reactivex.Single

class NoteViewModel(private val noteDao: NoteDao) : ViewModel() {

    fun getAllNotes(): Single<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    fun insertNote(note: NoteEntity): Completable {
        return noteDao.insertNote(note);
    }

}
