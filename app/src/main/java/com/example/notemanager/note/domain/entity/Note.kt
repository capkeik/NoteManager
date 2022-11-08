package com.example.notemanager.note.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Note(
    @PrimaryKey val id: Long,
    val title: String,
    val content: String,
    val changed: Date
)