package com.akshayfaye.noteit.database

import androidx.room.*
import com.akshayfaye.noteit.NoteEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_details WHERE title LIKE :title")
    fun findNoteByTitle(title: String): NoteEntity

    @Query("SELECT * FROM note_details")
    fun getAllNotes() : Single<List<NoteEntity>>

    @Insert
    fun insertNote(vararg note: NoteEntity) : Completable

    @Delete
    fun deleteNote(note: NoteEntity)

    @Update
    fun updateNote(vararg note: NoteEntity)
}