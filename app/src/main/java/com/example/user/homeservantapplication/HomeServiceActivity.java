package com.example.user.homeservantapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeServiceActivity extends AppCompatActivity {
    ListView listV_HomeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_service);

        //ActionBar Hi//
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        listV_HomeService=(ListView)findViewById(R.id.listV_HomeService);
        String[]serviceList=new String[]{"House Cleaning","Washing Clothes","Party Help","Window Cleaning","Cooking","Office Cleaning","Baby Setting","Kitchen Cleaning","Governess"};
        ArrayAdapter<String> serviceListAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,serviceList);
        listV_HomeService.setAdapter(serviceListAdapter);

        listV_HomeService.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listServiceName=(String)listV_HomeService.getItemAtPosition(position);
                switch (position){
                    case 0:
                        //Intent//
                        Intent intent_HomeCleaning=new Intent(getApplicationContext(),HomeCleaningActivity.class);
                        startActivity(intent_HomeCleaning);
                        finish();

                        break;
                    case 1:
                        Intent intentWashingCloth=new Intent(getApplicationContext(),WashingClothesActivity.class);
                        startActivity(intentWashingCloth);
                        finish();

                        break;
                    case 2:
                        Intent intentEventParty=new Intent(getApplicationContext(),PartyHelpActivity.class);
                        startActivity(intentEventParty);
                        finish();

                        break;
                    case 3:
                        Intent intentWinClean=new Intent(getApplicationContext(),WindowCleanActivity.class);
                        startActivity(intentWinClean);
                        finish();
                        break;
                    case 4:
                        Intent intentCooking=new Intent(getApplicationContext(),CookingActivity.class);
                        startActivity(intentCooking);
                        finish();

                        break;
                    case 5:
                        Intent intentOfficeClean=new Intent(getApplicationContext(),OfficeCleaningActivity.class);
                        startActivity(intentOfficeClean);
                        finish();

                        break;
                    case 6:
                        Intent intentBabysett=new Intent(getApplicationContext(),BabySettingActivity.class);
                        startActivity(intentBabysett);
                        finish();

                        break;
                    case 7:
                        Intent intentKitchencle=new Intent(getApplicationContext(),KitchenCleaningActivity.class);
                        startActivity(intentKitchencle);
                        finish();

                        break;
                    case 8:
                        Intent intentGoverness=new Intent(getApplicationContext(),GovernessActivity.class);
                        startActivity(intentGoverness);
                        finish();

                        break;

                }
            }
        });
    }
}
