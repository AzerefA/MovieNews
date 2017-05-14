package id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.Adapter;

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

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model.Favorite;

/**
 * Created by Akito on 14/05/2017.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    List<Favorite> list;
    Context context;

    public FavoriteAdapter(Context context,List<Favorite> list)
    {
        this.list = list;
        this.context = context;

    }


    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.ViewHolder holder, int position) {
        Favorite favorite = list.get(position);
        holder.tvTitle.setText(favorite.title);
        holder.tvDate.setText(favorite.release_date);
        holder.tvDesc.setText(favorite.overview);
        holder.rate.setText(favorite.vote_average);
    }

    @Override
    public int getItemCount() {
        if (list != null)
        {
            return list.size();
        }else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDate;
        public TextView tvDesc;
        public TextView rate;
        public ImageButton fav;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDate = (TextView) itemView.findViewById(R.id.rilisdate);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            rate = (TextView) itemView.findViewById(R.id.rating);
            fav = (ImageButton) itemView.findViewById(R.id.buttonFavorite);

        }
    }
}
