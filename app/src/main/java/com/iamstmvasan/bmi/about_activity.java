package com.iamstmvasan.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;


public class about_activity extends AppCompatActivity {
    Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        toolbar2 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);
        toolbar2.setTitle("ABOUT");
        toolbar2.setTitleTextColor(Color.WHITE);
    }
}
