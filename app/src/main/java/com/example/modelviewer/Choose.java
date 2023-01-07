package com.example.modelviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Button animalsButton = (Button) findViewById(R.id.animal_list_button);
        Button zoosButton = (Button) findViewById(R.id.zoo_location_listbutton);
        Context context = this;
        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AnimalsListView.class);
                view.getContext().startActivity(intent);
            }
        });
        zoosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsList.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
