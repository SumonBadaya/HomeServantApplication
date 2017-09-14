package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeCleaningActivity extends AppCompatActivity {
    ImageButton imageButton_HomeCleaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cleaning);

        imageButton_HomeCleaning=(ImageButton)findViewById(R.id.imageButton_HomeCleaning);
        imageButton_HomeCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHomeService=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentHomeService);
                finish();
            }
        });
    }

}
