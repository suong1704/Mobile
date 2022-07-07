package com.example.jetnote.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.NoteReponsitory
import com.example.jetnote.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val reponsitory: NoteReponsitory)
    : ViewModel(){
    private  val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init{
        viewModelScope.launch (  Dispatchers.IO ){
            reponsitory.getAllNotes().distinctUntilChanged()
                .collect {
                    listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()){
                        Log.d("DEBUG" , "Null or Empty")
                    }
                    else{
                        _noteList.value = listOfNotes
                    }
                }

        }
    }
    fun addNote(note: Note) = viewModelScope.launch { reponsitory.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { reponsitory.updateNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch { reponsitory.deleteNote(note) }

}