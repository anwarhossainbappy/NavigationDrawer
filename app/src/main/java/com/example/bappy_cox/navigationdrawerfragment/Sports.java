package com.example.bappy_cox.navigationdrawerfragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sports extends Fragment {
    private RecyclerView rv;
    List<News> employeelist, newlist;
    RecyclerAdapter empdapter;
    String sportsdata;
    ProgressDialog dialog;

View view;
    public Sports() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_sports, container, false);
        rv= (RecyclerView) view.findViewById(R.id.recyclerId);

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Loading....");
        dialog.show();



        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);



        employeelist =new ArrayList<>();
        newlist =new ArrayList<>();
        //url=getString(R.string.baseurl)+"fetchteamprofile.php";
        sportsdata="http://192.168.43.2/bappy/sportsdata.php";
        // sportsdataurl1="http://192.168.43.2/bappy/sportsdata.php";

        getsportsdata();
        return view;
    }

    private void getsportsdata() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(sportsdata, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){

                    try {
                        dialog.dismiss();
                        JSONObject object = response.getJSONObject(i);
                        //--add bind data to list--//
                        employeelist.add(new News(
                                object.getString("image"),
                                object.getString("title"),
                                object.getString("category"),
                                object.getString("date"),
                                object.getString("writer"),
                                object.getString("details")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //--adding data to recycler view--//

                    empdapter = new RecyclerAdapter(employeelist,getActivity());
                    rv.setAdapter(empdapter);
                    empdapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT).show();
            }
        });

        com.example.bappy_cox.navigationdrawerfragment.AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
    }


