package com.akshayfaye.noteit

import android.R
import android.R.id
import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.google.android.material.snackbar.Snackbar.make

object Utility {
    const val DATABASE_TABLE_NAME : String = "note_details"
    const val DATABASE_NAME : String = "note_database.db"

    const val NOTE_KEY : String = "note_key"

    //Default value for new note
    const val noteId : Int = -1;
}