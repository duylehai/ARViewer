package com.example.modelviewer;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MapsList extends AppCompatActivity {

    private final ArrayList<ListAddress> listAddresses = new ArrayList<>();
    private ListAddressAdapter mAdapter;
    private RecyclerView mRecyclerView;

    private void setUpAminoAcidModels(){
        String[] name = getResources().getStringArray(R.array.ListOfParkNames);
        String[] address = getResources().getStringArray(R.array.ListOfAddresses);
        String[] longtitude = getResources().getStringArray(R.array.listOfLongtitudes);
        String[] latitude = getResources().getStringArray((R.array.listOfLatitudes));
        TypedArray ImageResources = getResources().obtainTypedArray(R.array.ParkImages);

        // Clear the existing data (to avoid duplication).
        listAddresses.clear();

        // Create the ArrayList of Sports objects with the titles and
        // information about each sport
        for (int i = 0; i < latitude.length; i++) {
            listAddresses.add(new ListAddress(name[i], address[i], Float.parseFloat(longtitude[i]), Float.parseFloat(latitude[i]), ImageResources.getResourceId(i, 0)));
        }

        // Recycle the typed array.
        ImageResources.recycle();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        setUpAminoAcidModels();
        ListAddressAdapter adapter = new ListAddressAdapter(this, listAddresses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));}
}