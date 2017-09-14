package com.example.user.homeservantapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import de.hdodenhof.circleimageview.CircleImageView;

public class HomeUserSeekerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MyDataBaseProfile db;
    //CircleImageView profile_image_Seeker;

    ViewFlipper viewFlipper;
    Animation fadeIn, fadeOut;


    DrawerLayout Seeker_drawer_layout;
    ActionBarDrawerToggle abToggle;
    NavigationView Seeker_Navigation_view;

    TextView TV_Seeker_UserName,TV_Seeker_PhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user_seeker);

        //profile_image_Seeker=(CircleImageView)findViewById(R.id.profile_image_Seeker);

        String Seeker_Location=getIntent().getStringExtra("intentSeeker_Location");
        String Seeker_FirstName = getIntent().getStringExtra("intentSeeker_FirstName");
        String Seeker_LastName = getIntent().getStringExtra("intentSeeker_LastName");

        AlertDialog.Builder builderWelcomSuccess_Maid = new AlertDialog.Builder(HomeUserSeekerActivity.this);
        builderWelcomSuccess_Maid.setTitle("Welcome to Home Page..");
        builderWelcomSuccess_Maid.setMessage(Seeker_FirstName + " " + Seeker_LastName);


        builderWelcomSuccess_Maid.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

            }
        });

        builderWelcomSuccess_Maid.show();


        TV_Seeker_UserName=(TextView)findViewById(R.id.TV_Seeker_UserName);
        TV_Seeker_PhoneNumber=(TextView)findViewById(R.id.TV_Seeker_PhoneNumber);
        TV_Seeker_UserName.setText(Seeker_FirstName+" "+Seeker_LastName);
        TV_Seeker_PhoneNumber.setText(Seeker_Location);

        Seeker_Navigation_view=(NavigationView)findViewById(R.id.Seeker_Navigation_view);

        Seeker_drawer_layout=(DrawerLayout)findViewById(R.id.Seeker_drawer_layout);
        abToggle=new ActionBarDrawerToggle(this,Seeker_drawer_layout,R.string.open,R.string.close);
        Seeker_drawer_layout.addDrawerListener(abToggle);
        abToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Seeker_Navigation_view.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (abToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //*****Login Page DialogFrom opne Code//

    public void logInMethod(View view){
        switch (view.getId()){


            case R.id.buttonGallery:
                Intent intentGellary=new Intent(getApplicationContext(),GalleryActivity.class);
                startActivity(intentGellary);
                //showDialog();
                break;
            case R.id.buttonMaidServantHome:
                try {
                    Intent intentMaidServantList=new Intent(getApplicationContext(),MaidServantActivity.class);
                    startActivity(intentMaidServantList);
                }catch (Exception e){
                    e.printStackTrace();

                }

                //showDialog();
                break;
            case R.id.button_HomeService:
                try {
                    Intent intentHomeService= new Intent(getApplicationContext(),HomeServiceActivity.class);
                    startActivity(intentHomeService);
                }catch (Exception e){
                    e.printStackTrace();

                }


                break;

            case R.id.button_ServiceArea:

                break;

        }
    }

    @Override
    public void onBackPressed() {
        Seeker_drawer_layout=(DrawerLayout)findViewById(R.id.Seeker_drawer_layout);
        if (Seeker_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            Seeker_drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_textView) {

        } else if (id == R.id.nav_editResume) {

        } else if (id == R.id.nav_change_password) {

        } else if (id == R.id.nav_per_work_service) {

        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder alert = new AlertDialog.Builder(HomeUserSeekerActivity.this);
            alert.setTitle("Logout Message");
            alert.setMessage("Do you want to log out");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alert.show();


        }

        Seeker_drawer_layout=(DrawerLayout)findViewById(R.id.Seeker_drawer_layout);
        Seeker_drawer_layout.closeDrawer(GravityCompat.START);

        return true;
    }

    //**User Profile Picture**///

    public void MethodHomeSeekerUserPic(View view){
        showUserProfilePicDialog();

        db=new MyDataBaseProfile(this);

    }

    private void showUserProfilePicDialog() {
        final Dialog profileChooseDiaglog = new Dialog(this);

        profileChooseDiaglog.setContentView(R.layout.user_image_dialogbox);
        profileChooseDiaglog.setTitle("Profile Picture Choose");


        //First Button//
        Button buttonUserProfileChocs = (Button) profileChooseDiaglog.findViewById(R.id.buttonUserProfileChocs);
        buttonUserProfileChocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPic();

            }
        });

        //Secand Button///
        Button buttonUserProfileDisplay = (Button) profileChooseDiaglog.findViewById(R.id.buttonUserProfileDisplay);

        buttonUserProfileDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //profile_image_Seeker=(CircleImageView)findViewById(R.id.profile_image_Seeker);
//
//                Cursor cursor=db.display();
//
//                if(cursor!=null){
//
//                    cursor.moveToLast();
//                    byte[] data = cursor.getBlob(1);
//                    //profile_image_Seeker.setImageBitmap(getImage(data));
//                    Toast.makeText(getApplicationContext(),"Display the Last Photo",Toast.LENGTH_SHORT).show();
//                    profileChooseDiaglog.dismiss();
//
//                }else {
//                    Log.e("cursor","null");
//                }
            }
        });
        profileChooseDiaglog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//
//        if(resultCode==RESULT_OK){
//            Uri imageUri=data.getData();
//
//            InputStream inputStream=null;
//
//            try {
//                inputStream=getContentResolver().openInputStream(imageUri);
//                Bitmap image= BitmapFactory.decodeStream(inputStream);
//                db.createAndPass(getBytes(image));
//                Toast.makeText(this,"Stored into Database",Toast.LENGTH_SHORT).show();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
    }


    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public boolean selectPic(){
        try{
            Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,1);
        }catch (Exception e){
            return false;
        }
        return true;
    }



}
