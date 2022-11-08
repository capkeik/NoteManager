package com.example.notemanager.note.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey val id: Long,
    val title: String
)
