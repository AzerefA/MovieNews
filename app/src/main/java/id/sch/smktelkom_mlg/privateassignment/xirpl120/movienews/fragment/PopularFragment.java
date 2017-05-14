package id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.Adapter.MovieAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.Service.VolleySingleton;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model.Favorite;
import id.sch.smktelkom_mlg.privateassignment.xirpl120.movienews.model.Movie;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {
    private static final String URL_DATA = "https://api.themoviedb.org/3/movie/popular?api_key=a70e201d53913ab955e44d1b4869c94e&language=en-US&page=1";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Movie> data;
    Favorite fav;


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        data = new ArrayList<>();
        getDataPop();
        return view;
    }

    private void getDataPop() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading..");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ab) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(ab);
                            JSONArray array = jsonObject.getJSONArray("results");
                            //JSONObject o=array.getJSONObject(mKey);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                Movie item = new Movie(
                                        o.getString("poster_path"),
                                        o.getString("overview"),
                                        o.getString("release_date"),
                                        o.getString("title"),
                                        o.getString("vote_average")
                                );
                                data.add(item);
                            }
                            adapter = new MovieAdapter(getActivity().getApplicationContext(),data);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Log.e("FLOW", "onErrorResponse: ", volleyError);
                    }

                });
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }

}
