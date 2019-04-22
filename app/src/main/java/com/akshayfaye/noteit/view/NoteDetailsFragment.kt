package com.akshayfaye.noteit.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.akshayfaye.noteit.*
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NoteDetailsFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var viewModelFactory: NoteViewModelFactory
    private val disposable = CompositeDisposable()
    private val TAG : String = "NoteDetailsFragment"
    private var noteId: Int? = -1;

    companion object{

        fun newInstance(noteId : Int): NoteDetailsFragment{
            val noteDetailsFragment = NoteDetailsFragment()
            val bundle = Bundle()
            bundle.putInt(Utility.NOTE_KEY, noteId)
            noteDetailsFragment.arguments = bundle
            return noteDetailsFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragmentView =   inflater.inflate(R.layout.fragment_note_details, container, false)

        val args = arguments
        checkNoteId(args?.getInt(Utility.NOTE_KEY, Utility.noteId))


        return fragmentView;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_menu, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.action_save -> saveNote()
            R.id.action_delete -> Log.e(TAG, "delete")
            else -> Log.e(TAG, "else")

        }

        return super.onOptionsItemSelected(item)
    }


    private fun checkNoteId(noteId : Int?){

        this.noteId = noteId

        when (noteId) {
            -1 -> Log.e(TAG,"Note == -1")
            else -> {
                fetchNoteByID(noteId)
            }
        }
    }

    private fun fetchNoteByID(noteId: Int?){


    }

    private fun saveNote(){

        viewModelFactory = Injection.provideViewModelFactory(requireContext())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NoteViewModel::class.java)

        /*disposable.add(viewModel.insertNote()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list -> updateList(list, fragmentView) },
                        { error -> Log.e(TAG, "Failed to show", error) }

                ))*/

    }
}
