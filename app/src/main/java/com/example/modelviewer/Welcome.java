package com.example.modelviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    private Button welcome_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome_button = (Button) findViewById(R.id.button_welcome_start);
        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChooseActivity();
            }
        });
    }
    public void openChooseActivity() {
        Intent intent = new Intent(this, Choose.class);
        startActivity(intent);
    }
}
