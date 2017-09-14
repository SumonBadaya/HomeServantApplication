package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PartyHelpActivity extends AppCompatActivity {
    ImageButton imageButton_EventParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_help);
        imageButton_EventParty=(ImageButton)findViewById(R.id.imageButton_EventParty);
        imageButton_EventParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEventParty=new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentEventParty);
                finish();
            }
        });
    }
}
