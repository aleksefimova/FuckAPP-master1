package com.example.a111.fuckapp;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * A Repository to manage the Querys and allow to use multiple backends (data from network or local)
 */

public class SessionsRepository {

    private SessionDAO mSessionDAO;
    private List<String> mAllTitles;
    private List<String> mMarkersFromID;
    private List<String> mMarkersFromTitle;

    SessionsRepository(Application application){ //the constructor method
        SessionsRoomDatabase db = SessionsRoomDatabase.getDatabase(application); //initialize the database
        mSessionDAO = db.sessionDAO(); //initialize the DAO
        mAllTitles = mSessionDAO.getAllTitles(); //initialize the DAO method
        //mMarkersFromID = mSessionDAO.SelectMarkersFromID(); //not sure how to handle a int parameter
        //mMarkersFromTitle = mSessionDAO.SelectMarkersFromTitle(); //not sure how to handle a string parameter
    }

    List<String> getAllTitles(){ //wrapper for getAllTitles, should also be done for SelectMarkersFrom...
        return mAllTitles;
    }

    public void insert (Sessions sessions){ //wrapper for insert method, the async is to prevent the app from crashing because blocking the UI by long-running operations
        new insertAsyncTask(mSessionDAO).execute(sessions);
    }

    public void delete (Sessions sessions){
        new insertAsyncTask(mSessionDAO).execute(sessions);
    }

    public void update (Sessions sessions){
        new insertAsyncTask(mSessionDAO).execute(sessions);
    }

    //implement the assynchronouse task
    private static class insertAsyncTask extends AsyncTask<Sessions, Void, Void> {

        private SessionDAO mAsyncTaskDao;

        insertAsyncTask(SessionDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Sessions... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
