package com.akshayfaye.noteit.view

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshayfaye.noteit.*
import com.google.android.material.snackbar.Snackbar
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_note_list.*
import kotlinx.android.synthetic.main.fragment_note_list.view.*

class NoteListFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var viewModelFactory: NoteViewModelFactory
    private val disposable = CompositeDisposable()
    private val TAG : String = "NoteListFragment"

    companion object {

        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val fragmentView =  inflater.inflate(R.layout.fragment_note_list, container, false)

        viewModelFactory = Injection.provideViewModelFactory(requireContext())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NoteViewModel::class.java)

        disposable.add(viewModel.getAllNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list -> updateList(list, fragmentView) },
                        { error -> Log.e(TAG, "Failed to show", error) }

        ))

        return fragmentView
    }

    private fun updateList(noteList: List<NoteEntity>, fragmentView: View){

        if(noteList.isNotEmpty()){
            fragmentView.note_rv_list.layoutManager = LinearLayoutManager(requireContext())
            fragmentView.note_rv_list.adapter = NoteAdapter(noteList, requireContext())
        }else{
            Snackbar.make(fragmentView, "No notes found", Snackbar.LENGTH_SHORT).show();
        }

    }

}
