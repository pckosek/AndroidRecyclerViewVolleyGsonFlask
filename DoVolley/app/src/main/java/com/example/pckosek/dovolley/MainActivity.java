package com.example.pckosek.dovolley;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /* ------------------------------------------*/
    /*    MEMBER VARIABLES                      */
    ResponseHelper mResponseHelper;


    /* ------------------------------------------*/
    /*    LIFECYCLE METHODS                      */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mResponseHelper = new ResponseHelper();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    /* ------------------------------------------*/
    /*    INTERFACE METHODS                      */


    @Override
    public void onClick(View view) {

        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        String url ="https://pk.sites.tjhsst.edu/";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, mResponseHelper, mResponseHelper);
        mRequestQueue.add(stringRequest);
    }


    /* ------------------------------------------*/
    /*    HELPER CLASSES                         */

    class ResponseHelper implements Response.Listener<String>, Response.ErrorListener {

        public ResponseHelper() {
        }

        @Override
        public void onResponse(String response) {
            Log.i("KOSEK", response);
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i("KOSEK", "error");
        }

    }
}
