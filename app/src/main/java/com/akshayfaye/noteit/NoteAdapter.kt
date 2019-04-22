package com.akshayfaye.noteit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_list_item.view.*

class NoteAdapter (private val noteArrayList: List<NoteEntity>, private val context: Context?) : RecyclerView.Adapter<NoteAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return noteArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNote?.text = noteArrayList.get(position).title
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val tvNote = view.item_tv
    }

}