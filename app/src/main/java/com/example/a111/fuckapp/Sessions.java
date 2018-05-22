package com.example.a111.fuckapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.media.MediaCas;

import com.google.gson.Gson;

import java.util.ArrayList;

/**Entity of the Database that stores all the Sessions
 * it has a Id, Title, and the Markers ArrayList
 **/

@Entity
public class Sessions {

    @PrimaryKey(autoGenerate = true) //Autoincrementing Id
    private int Ids;

    @ColumnInfo(name = "Title") //Title Column
    private String SessionTitle;

    @ColumnInfo(name = "Markers") //Markers Column
    private String Markers;

    //Constructors of the Class
    public Sessions (){} //needs to be there;

    public Sessions(String title, ArrayList markers){
        String json = new Gson().toJson(markers);
        this.Markers = json;
        this.SessionTitle = title;
    }

    //Getter and Setter Method is nescessary for the Room Database if the columns are not public
    public int getIds(){return this.Ids;}

    public String getSessionTitle(){return this.SessionTitle;}

    public String getMarkers(){return this.Markers;}

    void setIds(int ids){this.Ids = ids;}

    void setSessionTitle(String title){this.SessionTitle = title;}

    void setMarkers(String markers){this.Markers = markers;}
}
