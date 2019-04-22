package com.akshayfaye.noteit.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.akshayfaye.noteit.NoteViewModel
import com.akshayfaye.noteit.R
import com.akshayfaye.noteit.Utility.noteId
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {view ->

            jumpToNoteDetailsFragment(noteId)
        }

        jumpToNoteListFragment();

    }

    private fun jumpToNoteListFragment(){

        val fragmentManager = supportFragmentManager
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, NoteListFragment.newInstance())
                .commit()
    }

    private fun jumpToNoteDetailsFragment(noteId : Int){

        val fragmentManager = supportFragmentManager
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, NoteDetailsFragment.newInstance(noteId))
                .commit()
    }
}
