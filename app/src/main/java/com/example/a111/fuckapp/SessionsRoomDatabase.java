package com.example.a111.fuckapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * The actual Database
 */

@Database(entities = {Sessions.class}, version = 1) //declaring which entities belong to the database and the version number
public abstract class SessionsRoomDatabase extends RoomDatabase {

    public abstract SessionDAO sessionDAO(); //the used DAO

    private static SessionsRoomDatabase INSTANCE; // to get sure we only have one instance of SessionsRoomDatabase

    public static SessionsRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SessionsRoomDatabase.class){
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SessionsRoomDatabase.class, "SessionsDatabase").build(); //here the actual database is created
                }
            }
        }
        return INSTANCE;
    }
}
