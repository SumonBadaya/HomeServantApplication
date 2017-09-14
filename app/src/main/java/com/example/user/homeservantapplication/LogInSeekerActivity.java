package com.example.user.homeservantapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInSeekerActivity extends AppCompatActivity {

    EditText eT_LogSeeker_UserName,eT_LogSeeker_Password;
    Button button_Login_Seeker,button_Registration_Seeker;

    DBSeekerController dbSeekerController;
    SQLiteOpenHelper dbhelper;
    Cursor cursor;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_seeker);

        //ActionBar Hi//
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        dbhelper=new DBSeekerController(getApplicationContext());
        db=dbhelper.getReadableDatabase();

        eT_LogSeeker_UserName=(EditText) findViewById(R.id.eT_LogSeeker_UserName);
        eT_LogSeeker_Password=(EditText)findViewById(R.id.eT_LogSeeker_Password);

        button_Login_Seeker=(Button)findViewById(R.id.button_Login_Seeker);
        button_Login_Seeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userLogSeeker_UserName=eT_LogSeeker_UserName.getText().toString();
                String userLogSeeker_Password=eT_LogSeeker_Password.getText().toString();

                cursor=db.rawQuery("SELECT * FROM "+DBSeekerController.TABLE_NAME+" WHERE "+ DBSeekerController.COLUMN_SEEKER_USER_NAME+" =? AND "+DBSeekerController.COLUMN_SEEKER_PASSWORD+" =? ",new String[]{userLogSeeker_UserName,userLogSeeker_Password});
                if (cursor.getCount()>0){
                    cursor.moveToFirst();
                    String userSeekerFirst_Name=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_FIRST_NAME));
                    String userSeekerLast_Name=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_LAST_NAME));
                    String userSeekerUser_Name=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_USER_NAME));
                    String userSeekerGender=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_GENDER));
                    String userSeekerAge=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_AGE));
                    String userSeekerPhone_Number=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_PHONE_NUMBER));
                    String userSeekerNID=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_NID));
                    String userSeekerLocation=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_LOCATION));
                    String userSeekerAddress=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_ADDRESS));
                    String userSeekerPassord=cursor.getString(cursor.getColumnIndex(DBSeekerController.COLUMN_SEEKER_PASSWORD));

                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();

                    Intent intentLogSuccessSeeker=new Intent(getApplicationContext(),HomeUserSeekerActivity.class);
                    intentLogSuccessSeeker.putExtra("intentSeeker_FirstName",userSeekerFirst_Name);
                    intentLogSuccessSeeker.putExtra("intentSeeker_LastName",userSeekerLast_Name);
                    intentLogSuccessSeeker.putExtra("intentSeeker_UserName",userSeekerUser_Name);
                    intentLogSuccessSeeker.putExtra("intentSeeker_Gender",userSeekerGender);
                    intentLogSuccessSeeker.putExtra("intentSeeker_Age",userSeekerAge);
                    intentLogSuccessSeeker.putExtra("intentSeeker_PhoneNum",userSeekerPhone_Number);
                    intentLogSuccessSeeker.putExtra("intentSeeker_NID",userSeekerNID);
                    intentLogSuccessSeeker.putExtra("intentSeeker_Location",userSeekerLocation);
                    intentLogSuccessSeeker.putExtra("intentSeeker_Address",userSeekerAddress);
                    intentLogSuccessSeeker.putExtra("intentSeeker_Password",userSeekerPassord);

                    startActivity(intentLogSuccessSeeker);
                    eT_LogSeeker_UserName.setText("");
                    eT_LogSeeker_Password.setText("");




                } else {

                    //I am showing Alert Dialog Box here for alerting user about wrong credentials
                    final AlertDialog.Builder builder = new AlertDialog.Builder(LogInSeekerActivity.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Invalid Username or Password.");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface,int i) {

                            dialogInterface.dismiss();

                        }
                    });

                    //AlertDialog dialog = builder.create();
                    builder.show();
                    //-------Alert Dialog Code Snippet End Here


                    //checkIsValide(email,password);
                    //dbController.checkIsValideUser(email, password);
                }


            }
        });

        button_Registration_Seeker=(Button)findViewById(R.id.button_Registration_Seeker);
        button_Registration_Seeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentRegSeeker=new Intent(getApplicationContext(),RegistrationSeekerActivity.class);
                startActivity(intentRegSeeker);

            }
        });



    }
    /***public void seekerLogRegMethod(View view){
     switch (view.getId()){

     case R.id.button_Registration_Seeker:

     }
     }***/
}
