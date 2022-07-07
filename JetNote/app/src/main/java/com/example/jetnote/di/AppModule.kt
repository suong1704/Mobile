//package com.example.jetnote.di
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import com.example.jetnote.data.NoteDatabase
//import com.example.jetnote.data.NoteDatabaseDAO
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Singleton
//    @Provides
//    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDAO = noteDatabase.noteDao()
//
//    @Singleton
//    @Provides
//    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase
//    = Room.databaseBuilder(
//        context,
//        NoteDatabase::class.java,
//        "notes"
//    )
//        .fallbackToDestructiveMigration()
//        .build()
//
//}