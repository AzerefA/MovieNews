package id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model.Favorite;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model.Movie;

/**
 * Created by Akito on 13/05/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>
{

    List<Movie> list;
    Context context;


    public MovieAdapter(Context context, List<Movie> list)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Movie dataItem = list.get(position);
        holder.tvTitle.setText(dataItem.getTitle());
        holder.tvDate.setText(dataItem.getRelease_date());
        holder.tvDesc.setText(dataItem.getOverview());
        holder.rate.setText("Rating:  "+ dataItem.getVote_average());
        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + dataItem.getPoster_path())
                .into(holder.ivMovie);
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String poster = dataItem.getPoster_path();
                String title = dataItem.getTitle();
                String overview = dataItem.getOverview();
                String release = dataItem.getRelease_date();
                String vote = dataItem.getVote_average();
                Favorite favorite = new Favorite(poster,overview,release,title,vote);
                favorite.save();
            }
        });

    }


    @Override
    public int getItemCount()
    {
            return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView ivMovie;
        public TextView tvTitle;
       public TextView tvDate;
       public TextView tvDesc;
        public TextView rate;
        public ImageButton fav;


        public ViewHolder(View itemView)
        {
            super(itemView);
            ivMovie = (ImageView) itemView.findViewById(R.id.imageView);
            tvTitle = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDate = (TextView) itemView.findViewById(R.id.rilisdate);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            rate = (TextView) itemView.findViewById(R.id.rating);
            fav = (ImageButton) itemView.findViewById(R.id.buttonFavorite);

        }
    }
}