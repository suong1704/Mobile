package com.example.jetnote.data

import com.example.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteReponsitory @Inject constructor(private val noteDatabaseDAO: NoteDatabaseDAO){
    suspend fun addNote(note: Note) = noteDatabaseDAO.insert(note)
    suspend fun updateNote(note: Note) = noteDatabaseDAO.update(note)
    suspend fun deleteNote(note: Note) = noteDatabaseDAO.delete(note)
    suspend fun deleteAllNotes() = noteDatabaseDAO.deleteALl()
    fun getAllNotes(): Flow<List<Note>> = noteDatabaseDAO.getAllNotes().flowOn(Dispatchers.IO)
}