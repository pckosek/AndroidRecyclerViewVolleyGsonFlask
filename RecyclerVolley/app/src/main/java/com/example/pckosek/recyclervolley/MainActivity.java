package com.example.pckosek.recyclervolley;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /* ------------------------*/
    /*    member variables     */

    private List<RestaurantOrder> restaurantOrderList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrderItemAdapter mAdapter;

    /* ------------------------------------------*/
    /*    LIFECYCLE METHODS                      */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new OrderItemAdapter(restaurantOrderList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    /* ------------------------------------------*/
    /*    INTERFACE METHODS                      */

    @Override
    public void onClick(View v) {

        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        String url ="https://pk.sites.tjhsst.edu/";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.i("RESPONSE", response);

                        Gson gson = new GsonBuilder().create();     // instantiate a gson builder
                        RestaurantOrder thisItem = gson.fromJson(response, RestaurantOrder.class);

                        restaurantOrderList.add(thisItem);
                        mAdapter.notifyDataSetChanged();

                   }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("KOSEK", "error");
            }
        });

        mRequestQueue.add(stringRequest);
    }
}
