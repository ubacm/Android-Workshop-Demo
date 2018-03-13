package com.tristanwiley.acmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// This is our Main Activity. This is what will show when we start the app.
public class MainActivity extends AppCompatActivity {

    // onCreate is the first method that is called when we start our app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView sets the layout file to this Activity
        setContentView(R.layout.activity_main);

        // Get the Buttons and TextView from our layout
        Button changeTextButton = findViewById(R.id.changeText);
        Button changeActivity = findViewById(R.id.changeActivity);
        final TextView textView = findViewById(R.id.textView);

        // When you click the changeTextButton, do something
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the text of the TextView to be something!
                // This reads from the strings.xml file, but can be any String "Hello World"
                textView.setText(R.string.some_text);
            }
        });

        // When you click on the changeActivity button, let's move to a new activity
        changeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to move from this Activity to our ListActivity
                Intent newActivityIntent = new Intent(MainActivity.this, ListActivity.class);

                // Pass our intent to the startActivity and open the new Activity
                startActivity(newActivityIntent);
            }
        });
    }
}
