package com.tristanwiley.acmapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    /* When the ListActivity is created set the layout and get access
     * to the RecyclerView, then set a LayoutManager and the adapter to show
     * the content in the ArrayList.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Get our RecyclerView from the activity_list layout
        RecyclerView ourCoolList = findViewById(R.id.recyclerView);

        // Create a new ArrayList to store the strings we want to display
        // We could call some API to get these too if we wanted to!
        ArrayList<String> companyNames = new ArrayList<>();
        companyNames.add("Google");
        companyNames.add("Apple");
        companyNames.add("Microsoft");

        // Create a new ListAdapter and pass in the String of names
        ListAdapter adapter = new ListAdapter(companyNames);

        // Set the LayoutManager to be a linear layout (vertical by default)
        ourCoolList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // Finally set the adapter to the RecyclerView
        ourCoolList.setAdapter(adapter);
    }
}
