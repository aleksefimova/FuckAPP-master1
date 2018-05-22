package com.example.a111.fuckapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import java.util.List;

/**
 * The ViewModel is to cache the UI data so that is survives configuration changes
 */

public class SessionsViewModel extends AndroidViewModel {
    private SessionsRepository mRepository;
    private List<String> mAllTitles;

    //Constructor to get reference to the repository and the list of titles
    public SessionsViewModel(Application application) {
        super(application);
        mRepository = new SessionsRepository(application);
        mAllTitles = mRepository.getAllTitles();
    }

    //This completely hides the implementation from the UI
    List<String> getAllTitles() {return mAllTitles;}
    public void insert(Sessions sessions) {mRepository.insert(sessions);}
}
