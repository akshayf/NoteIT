package com.akshayfaye.noteit.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshayfaye.noteit.NoteAdapter
import com.akshayfaye.noteit.NoteViewModel
import com.akshayfaye.noteit.R
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_note_list.view.*

class NoteListFragment : Fragment() {

    private val noteArrayList: ArrayList<String> = ArrayList()

    private lateinit var viewModel: NoteViewModel

    companion object {

        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val fragmentView =  inflater.inflate(R.layout.fragment_note_list, container, false)

        fragmentView.note_rv_list.layoutManager = LinearLayoutManager(context)
        fragmentView.note_rv_list.adapter = NoteAdapter(noteArrayList, context)

        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

    }
}
