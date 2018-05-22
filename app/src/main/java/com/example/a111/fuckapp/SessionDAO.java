package com.example.a111.fuckapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * This is where the "SQL" happens
 */

@Dao
public interface SessionDAO {

    @Insert //Insert a "row"
    void insert(Sessions sessions);

    @Delete //delete a "row"
    void delete(Sessions sessions);

    @Update // update a "row"
    void update(Sessions sessions);

    @Query("SELECT Title FROM sessions") //selects the titles of all rows in a List of Strings
    List<String> getAllTitles(); //LiveData should be applied here to work after a delete

    @Query("SELECT Markers FROM  sessions WHERE Ids == :ids") //selects the Markers form a given ID
    List<String> SelectMarkersFromID(int ids);

    @Query("SELECT Markers FROM  sessions WHERE Title == :title") //selects the Markers form a given ID
    List<String> SelectMarkersFromTitle(int title);

}
