package com.akshayfaye.noteit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akshayfaye.noteit.NoteEntity
import com.akshayfaye.noteit.Utility

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance
                ?: synchronized(LOCK){
            instance
                    ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                NoteDatabase::class.java, Utility.DATABASE_NAME)
                .build()
    }
}