package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OfficeCleaningActivity extends AppCompatActivity {
    ImageButton imageButton_OfficeCleaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_cleaning);

        imageButton_OfficeCleaning=(ImageButton)findViewById(R.id.imageButton_OfficeCleaning);
        imageButton_OfficeCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOfficeCle=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentOfficeCle);
                finish();
            }
        });
    }
}
