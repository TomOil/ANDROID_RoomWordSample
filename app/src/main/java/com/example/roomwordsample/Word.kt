package com.example.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Word(val word: String)
{
    @Entity(tableName = "word_table") //Entity represents a SQLite table with name word_table
    class Word(

        @PrimaryKey(autoGenerate = true) val id: Int, //primary key with autogenerate option

        @ColumnInfo(name = "word") val word: String // name of the column

    )
}