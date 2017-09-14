package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BabySettingActivity extends AppCompatActivity {
    ImageButton imageButton_BabySetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_setting);

        imageButton_BabySetting=(ImageButton)findViewById(R.id.imageButton_BabySetting);
        imageButton_BabySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBabysetting=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentBabysetting);
                finish();
            }
        });
    }
}
