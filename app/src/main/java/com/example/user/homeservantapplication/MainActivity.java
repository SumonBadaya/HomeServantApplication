package com.example.user.homeservantapplication;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

//    ViewFlipper viewFlipper;
//    Animation fadeIn, fadeOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar Hi//
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();



        //no need those thing are in java file, i already included it into xml

        //viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
//        fadeIn= AnimationUtils.loadAnimation(this,R.anim.fade_in);
//        fadeOut=AnimationUtils.loadAnimation(this,R.anim.fade_out);

//        viewFlipper.setAutoStart(true);
//        viewFlipper.setInAnimation(fadeIn);
//        viewFlipper.setInAnimation(fadeOut);
//        viewFlipper.setFlipInterval(7000);
//        viewFlipper.startFlipping();

    }


    private void showDialog(){
        Dialog mydiaglog=new Dialog(this);

        mydiaglog.setContentView(R.layout.logdialog);
        mydiaglog.setTitle("LOGIN");


        //First Button//
        Button button_LogDialogMaid=(Button)mydiaglog.findViewById(R.id.button_LogDialogMaid);
       button_LogDialogMaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_maid=new Intent(getApplicationContext(),LogInMaidServandActivity.class);
                startActivity(intent_maid);
                finish();

            }
        });

        //Secand Button///
        Button button_LogDialogSeeker=(Button)mydiaglog.findViewById(R.id.button_LogDialogSeeker);

        button_LogDialogSeeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_seeker=new Intent(getApplicationContext(),LogInSeekerActivity.class);
                startActivity(intent_seeker);
                //*****Login Page DialogFram end Code//
                finish();

            }
        });
        mydiaglog.show();

    }
    public void logInMethod(View view){
        switch (view.getId()){

            case R.id.button_LogIn:
                showDialog();
                break;

           case R.id.buttonGallery:
                Intent intentGellary=new Intent(getApplicationContext(),GalleryActivity.class);
                startActivity(intentGellary);
                //showDialog();
                break;
            case R.id.buttonAbout:
                Intent intentAbout= new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intentAbout);

                //showDialog();
                break;
            case R.id.button_HomeService:
                Intent intentHomeService= new Intent(getApplicationContext(),HomeServiceActivity.class);
                startActivity(intentHomeService);

                break;

            // show GOOGLE map using this code

            case R.id.button_ServiceArea:
                String GPSurl="https://www.google.com.bd/maps/place/Dhaka/@23.8060349,90.3970428,14z/data=!4m5!3m4!1s0x3755b8b087026b81:0x8fa563bbdd5904c2!8m2!3d23.8103183!4d90.4125023?hl=en";
                Intent intentServiceMapArea=new Intent(Intent.ACTION_VIEW);
                intentServiceMapArea.setData(Uri.parse(GPSurl));
                startActivity(intentServiceMapArea);

                break;

        }

    }

}
