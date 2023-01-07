package com.example.modelviewer;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.modelviewer.AnimalData;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_detail);

        Log.d("lmaooo", "created successfully");

        String data = getIntent().getStringExtra("animalData");
        Gson gson = new Gson();
        AnimalData animalData = gson.fromJson(data, AnimalData.class);
        Log.d("lmaooo", "created data");
        ImageView mainImage = findViewById(R.id.animal_detail_main_image);
        mainImage.setImageResource(this.getResources().getIdentifier(animalData.getMainImg(), "drawable", this.getPackageName()));

        TextView detail = (TextView) findViewById(R.id.animal_detail_detail_info);
        detail.setText(animalData.details);

        TextView nameText = (TextView) findViewById(R.id.animal_detail_name);
        nameText.setText(animalData.name);
        TextView weightText = (TextView) findViewById(R.id.animal_detail_weight);
        weightText.setText(animalData.weight);
        TextView sizeText = (TextView) findViewById(R.id.animal_detail_size);
        sizeText.setText(animalData.size);

        Button arButton = findViewById(R.id.animal_detail_AR_view);
        arButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ARView.class);
                intent.putExtra("modelSrc",animalData.model);
                intent.putExtra("modelName", animalData.name);
                v.getContext().startActivity(intent);
            }
        });
    }
}
