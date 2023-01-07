package com.example.modelviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("creation","okay");
        //Intent intent = new Intent(this, ARView.class);
        //intent.setData(Uri.parse("https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb"));
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
}