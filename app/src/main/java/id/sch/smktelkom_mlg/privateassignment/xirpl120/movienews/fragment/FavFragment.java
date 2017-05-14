package id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.Adapter.FavoriteAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.Adapter.MovieAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model.Favorite;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    List<Favorite> fList = Favorite.listAll(Favorite.class);

    public FavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FavoriteAdapter(getActivity(),fList);
        recyclerView.setAdapter(adapter);
        refreshData();
        return view;
    }

    private void refreshData() {
        fList.clear();
        fList.addAll(Favorite.listAll(Favorite.class));
        adapter.notifyDataSetChanged();
    }


}
