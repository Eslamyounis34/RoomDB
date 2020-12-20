package com.example.roomdb;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities ={Note.class} ,version = 1)
public abstract class MyDataBase extends RoomDatabase {

    public abstract MyDOA myDOA();
}
