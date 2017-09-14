package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KitchenCleaningActivity extends AppCompatActivity {

    ImageButton imageButton_KitchenCleaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_cleaning);

        imageButton_KitchenCleaning=(ImageButton)findViewById(R.id.imageButton_KitchenCleaning);
        imageButton_KitchenCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKitchencle=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentKitchencle);
                finish();
            }
        });
    }
}
