package com.example.labexam04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.labexam04.database.NoteDatabase
import com.example.labexam04.repository.NoteRepository
import com.example.labexam04.viewmodel.NoteViewModel
import com.example.labexam04.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository =NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory =NoteViewModelFactory(application,noteRepository)
        noteViewModel =ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}