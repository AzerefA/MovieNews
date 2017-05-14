package id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Akito on 13/05/2017.
 */

public class Movie implements Serializable {
    private String poster_path;
    private String overview;
    private String release_date;
    private String title;
    private String vote_average;

    public Movie(String poster_path,String overview,
                 String release_date, String title,String vote_avarage){
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.title = title;
        this.vote_average= vote_avarage;
    }

    public String getPoster_path(){return poster_path;}
    public String getOverview(){return overview;}
    public String getRelease_date(){return release_date;}
    public String getTitle(){return title;}
    public String getVote_average(){return vote_average;}

}
