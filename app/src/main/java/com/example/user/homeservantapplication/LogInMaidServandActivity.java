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

public class LogInMaidServandActivity extends AppCompatActivity {

    EditText eT_LogMaid_UserName,eT_LogMaid_Password;
    Button button_Login_Maid,button_Registration_Maid;

    DBMaidController dbMaidController;
    SQLiteOpenHelper dbhelper;
    Cursor cursor;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_maid_servand);
        //ActionBar Hi//
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();


        dbhelper=new DBMaidController(getApplicationContext());
        db=dbhelper.getReadableDatabase();


        eT_LogMaid_UserName=(EditText)findViewById(R.id.eT_LogMaid_UserName);
        eT_LogMaid_Password=(EditText)findViewById(R.id.eT_LogMaid_Password);
        button_Login_Maid=(Button)findViewById(R.id.button_Login_Maid);


        button_Login_Maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userLogMaid_UserName = eT_LogMaid_UserName.getText().toString();
                String userLogMaid_Password = eT_LogMaid_Password.getText().toString();


                /*Database */
                cursor = db.rawQuery("SELECT * FROM " + DBMaidController.TABLE_NAME + " WHERE " + DBMaidController.COLUMN_MAID_USER_NAME + " =? AND " + DBMaidController.COLUMN_MAID_PASSWORD + " =? ", new String[]{userLogMaid_UserName, userLogMaid_Password});
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    String userMaidFirst_Name = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_FIRST_NAME));
                    String userMaidLast_Name = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_LAST_NAME));
                    String userMaidUser_Name = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_USER_NAME));
                    String userMaidGender = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_GENDER));
                    String userMaidAge = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_AGE));
                    String userMaidPhone_Number = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_PHONE_NUMBER));
                    String userMaidNID = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_NID));
                    String userMaidLocation = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_LOCATION));
                    String userMaidAddress = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_ADDRESS));
                    String userMaidPassword = cursor.getString(cursor.getColumnIndex(DBMaidController.COLUMN_MAID_PASSWORD));
                    String userMaidID = cursor.getString(cursor.getColumnIndex("ID"));

                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();


                    Intent intentLogSuccessMaid = new Intent(getApplicationContext(), HomeUserMaidServandActivity.class);
                    intentLogSuccessMaid.putExtra("intentMaid_FirstName", userMaidFirst_Name);
                    intentLogSuccessMaid.putExtra("intentMaid_LastName", userMaidLast_Name);
                    intentLogSuccessMaid.putExtra("intentMaid_UserName", userMaidUser_Name);
                    intentLogSuccessMaid.putExtra("intentMaid_Gender", userMaidGender);
                    intentLogSuccessMaid.putExtra("intentMaid_Age", userMaidAge);
                    intentLogSuccessMaid.putExtra("intentMaid_PhoneNumber", userMaidPhone_Number);
                    intentLogSuccessMaid.putExtra("intentMaid_NID", userMaidNID);
                    intentLogSuccessMaid.putExtra("intentMaid_Location", userMaidLocation);
                    intentLogSuccessMaid.putExtra("intentMaid_Address", userMaidAddress);
                    intentLogSuccessMaid.putExtra("intentMaid_Password", userMaidPassword);
                    intentLogSuccessMaid.putExtra("intentMaid_ID", userMaidID);


                    startActivity(intentLogSuccessMaid);
                    eT_LogMaid_UserName.setText("");
                    eT_LogMaid_Password.setText("");
                    finish();



                }else {

                    //I am showing Alert Dialog Box here for alerting user about wrong credentials
                    final AlertDialog.Builder builder = new AlertDialog.Builder(LogInMaidServandActivity.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Invalid Username or Password.");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

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

        button_Registration_Maid=(Button)findViewById(R.id.button_Registration_Maid);
        button_Registration_Maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_RegMaid=new Intent(getApplicationContext(),RegistrationMaidActivity.class);
                startActivity(intent_RegMaid);


            }
        });



    }

}
