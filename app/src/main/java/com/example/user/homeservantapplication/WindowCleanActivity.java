package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WindowCleanActivity extends AppCompatActivity {

    ImageButton imageButton_WindowClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_clean);

        imageButton_WindowClean=(ImageButton)findViewById(R.id.imageButton_WindowClean);
        imageButton_WindowClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWindow=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentWindow);
                finish();
            }
        });
    }
}
