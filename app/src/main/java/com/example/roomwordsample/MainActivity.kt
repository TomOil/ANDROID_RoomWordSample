package com.example.roomwordsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.*
import kotlinx.coroutines.flow.Flow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    data class Word(val word: String)
    {
        @Entity(tableName = "word_table") //Entity represents a SQLite table with name word_table
        class Word(

            @PrimaryKey(autoGenerate = true) val id: Int, //primary key with autogenerate option

            @ColumnInfo(name = "word") val word: String // name of the column

        )
    }

    @Dao  //identification as DAO class for Room
    interface WordDao {          //DAO must be interface or abstract class

        @Query("SELECT * FROM word_table ORDER BY word ASC")
        fun getAlphabetizedWords(): Flow<List<Word>>  //returns all words as List using Flow (async sequence of values)

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(word: Word)

        @Query("DELETE FROM word_table")
        suspend fun deleteAll()
    }
}