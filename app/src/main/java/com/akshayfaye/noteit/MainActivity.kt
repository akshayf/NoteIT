package com.akshayfaye.noteit

import android.os.Bundle
import android.view.View
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val noteArrayList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        addNotes()

        note_rv_list.layoutManager = LinearLayoutManager(this)
        note_rv_list.adapter = NoteAdapter(noteArrayList, this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    private fun addNotes() {
        noteArrayList.add("123")
        noteArrayList.add("234")
        noteArrayList.add("456")
        noteArrayList.add("1233")
        noteArrayList.add("2343")
        noteArrayList.add("4563")
        noteArrayList.add("1234")
        noteArrayList.add("2344")
        noteArrayList.add("4564")
        noteArrayList.add("123")
        noteArrayList.add("234")
        noteArrayList.add("456")
        noteArrayList.add("1233")
        noteArrayList.add("2343")
        noteArrayList.add("4563")
        noteArrayList.add("1234")
        noteArrayList.add("2344")
        noteArrayList.add("4564")
    }
}
