package com.example.roomdb;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyDOA {
    @Insert
    public void addNote(Note note);

    @Query("select * from notes")
    public List<Note> getNotes();

    @Delete
    public void deleteNote(Note note);

    @Update
    public void updateNote(Note note);
}
