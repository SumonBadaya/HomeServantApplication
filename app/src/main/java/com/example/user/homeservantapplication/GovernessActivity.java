package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GovernessActivity extends AppCompatActivity {
    ImageButton imageButton_Governess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_governess);

        imageButton_Governess=(ImageButton)findViewById(R.id.imageButton_Governess);
        imageButton_Governess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoverness=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentGoverness);
                finish();
            }
        });
    }
}
