package com.example.modelviewer;

import android.app.Application;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewer.databinding.ActivityMainBinding;

import com.example.modelviewer.AnimalsListAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.example.modelviewer.AnimalData;
import com.google.gson.Gson;

public class AnimalsListView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals_list);

        String[] animalsName = {"Tiger", "Penguin","Tiger", "Penguin"};
        int[] image = {R.drawable.tiger, R.drawable.penguin, R.drawable.tiger, R.drawable.penguin};

        Gson gson = new Gson();
        AnimalData[] animalData = {};
        InputStream is = getResources().openRawResource(R.raw.data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();
        animalData = gson.fromJson(jsonString, AnimalData[].class);
        Log.d("lmaooo",animalData[0].getName());
        //int resourceId = this.getResources().getIdentifier("penguin", "id", this.getPackageName());
        //Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(resourceId), Toast.LENGTH_SHORT);
        //toast.show(); ("android.resource://com.example.modelviewer/" + R.raw.data)
        AnimalsListAdapter adapter =  new AnimalsListAdapter(this, animalData);
        GridView gridView = findViewById(R.id.animalsGrid);
        gridView.setAdapter(adapter);

    }
}
