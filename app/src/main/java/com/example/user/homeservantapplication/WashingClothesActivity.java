package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WashingClothesActivity extends AppCompatActivity {
    ImageButton imageButton_WashingClothe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washing_clothes);

        imageButton_WashingClothe=(ImageButton)findViewById(R.id.imageButton_WashingClothe);
        imageButton_WashingClothe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWashingClothe=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentWashingClothe);
                finish();
            }
        });
    }

}
