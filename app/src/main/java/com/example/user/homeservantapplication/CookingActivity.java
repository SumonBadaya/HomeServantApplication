package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CookingActivity extends AppCompatActivity {
    ImageButton imageButton_Cooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
        imageButton_Cooking=(ImageButton)findViewById(R.id.imageButton_Cooking);
        imageButton_Cooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCooking=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentCooking);
                finish();
            }
        });
    }
}
