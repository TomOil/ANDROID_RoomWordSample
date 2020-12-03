package com.example.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table") //Entity represents a SQLite table with name word_table
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)