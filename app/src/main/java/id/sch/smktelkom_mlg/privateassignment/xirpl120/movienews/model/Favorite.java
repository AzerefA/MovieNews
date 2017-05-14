package id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Akito on 14/05/2017.
 */

public class Favorite extends SugarRecord implements Serializable {

    public String poster_path;
    public String overview;
    public String release_date;
    public String title;
    public String vote_average;

    public Favorite(){

    }

    public Favorite(String poster_path,String overview,
                    String release_date, String title,String vote_avarage){
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.title = title;
        this.vote_average= vote_avarage;
    }

    
}
