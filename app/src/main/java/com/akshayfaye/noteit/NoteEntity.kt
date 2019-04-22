package com.akshayfaye.noteit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Utility.DATABASE_TABLE_NAME)
data class NoteEntity (

    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String

)