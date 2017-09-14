package com.example.user.homeservantapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationSeekerActivity extends AppCompatActivity {
    EditText eT_Seeker_First_Name,eT_Seeker_Last_Name, eT_Seeker_UserName,eT_Seeker_Gender,eT_Seeker_Age,eT_Seeker_Location, eT_Seeker_PhoneNumber, eT_Seeker_NID, eT_Seeker_Address, eT_Seeker_Password, eT_Seeker_ConfirmPassword;
    Button button_Next_SeekerReg;

    Seeker seeker;
    DBSeekerController dbSeekerController;
    boolean inSeekerSuccess=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_seeker);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        eT_Seeker_First_Name=(EditText)findViewById(R.id.eT_Seeker_First_Name);
        eT_Seeker_Last_Name=(EditText)findViewById(R.id.eT_Seeker_Last_Name);
        eT_Seeker_UserName=(EditText)findViewById(R.id.eT_Seeker_UserName);
        eT_Seeker_Gender=(EditText)findViewById(R.id.eT_Seeker_Gender);
        eT_Seeker_Age=(EditText)findViewById(R.id.eT_Seeker_Age);
        eT_Seeker_Location=(EditText)findViewById(R.id.eT_Seeker_Location);
        eT_Seeker_PhoneNumber=(EditText)findViewById(R.id.eT_Seeker_PhoneNumber);
        eT_Seeker_NID=(EditText)findViewById(R.id.eT_Seeker_NID);
        eT_Seeker_Address=(EditText)findViewById(R.id.eT_Seeker_Address);
        eT_Seeker_Password=(EditText)findViewById(R.id.eT_Seeker_Password);
        eT_Seeker_ConfirmPassword=(EditText)findViewById(R.id.eT_Seeker_ConfirmPassword);


        button_Next_SeekerReg=(Button)findViewById(R.id.button_Next_SeekerReg);
        button_Next_SeekerReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userSeeker_FirstName=eT_Seeker_First_Name.getText().toString();
                String userSeeker_LastName=eT_Seeker_Last_Name.getText().toString();
                String userSeeker_UserName=eT_Seeker_UserName.getText().toString();
                String userSeeker_Gender=eT_Seeker_Gender.getText().toString();
                String userSeeker_Age=eT_Seeker_Age.getText().toString();
                String userSeeker_Location=eT_Seeker_Location.getText().toString();
                String userSeeker_PhoneNum=eT_Seeker_PhoneNumber.getText().toString();
                String userSeeker_NID=eT_Seeker_NID.getText().toString();
                String userSeeker_Address=eT_Seeker_Address.getText().toString();
                String userSeeker_Password=eT_Seeker_Password.getText().toString();
                String userSeeker_ConfPassword=eT_Seeker_ConfirmPassword.getText().toString();

                if (userSeeker_FirstName.isEmpty()){
                    eT_Seeker_First_Name.setError("Please Enter First Name");
                    eT_Seeker_First_Name.requestFocus();
                }else if(userSeeker_FirstName.length()>15){
                    eT_Seeker_First_Name.setError("Remove long First Name");
                    eT_Seeker_First_Name.requestFocus();
                }
                if(userSeeker_LastName.isEmpty()){
                    eT_Seeker_Last_Name.setError("Please Enter Last Name");
                    eT_Seeker_Last_Name.requestFocus();
                }else if (userSeeker_LastName.length()>10){
                    eT_Seeker_Last_Name.setError("Remove long Last Name");
                    eT_Seeker_Last_Name.requestFocus();
                }
                if(userSeeker_UserName.isEmpty()){
                    eT_Seeker_UserName.setError("Please Enter User Name");
                    eT_Seeker_UserName.requestFocus();
                }else if (userSeeker_UserName.length()>15){
                    eT_Seeker_UserName.setError("Remove long User Name");
                    eT_Seeker_UserName.requestFocus();
                }

                if(userSeeker_Gender.isEmpty()){
                    eT_Seeker_Gender.setError("Please Enter Female or Male");
                    eT_Seeker_Gender.requestFocus();
                }else if (userSeeker_Gender.length()>7){
                    eT_Seeker_UserName.setError("Invalid Female or Male");
                    eT_Seeker_UserName.requestFocus();
                }

                if(userSeeker_Age.isEmpty()){
                    eT_Seeker_Age.setError("Please Enter your age");
                    eT_Seeker_Age.requestFocus();
                }else if (userSeeker_Age.length()>3){
                    eT_Seeker_Age.setError("Invalid Age");
                    eT_Seeker_Age.requestFocus();
                }


                if(userSeeker_PhoneNum.isEmpty()){
                    eT_Seeker_PhoneNumber.setError("Please Enter Phone Number");
                    eT_Seeker_PhoneNumber.requestFocus();
                }else if (userSeeker_PhoneNum.length()>11){
                    eT_Seeker_PhoneNumber.setError("Invalid Phone Number");
                    eT_Seeker_PhoneNumber.requestFocus();
                }
                if(userSeeker_NID.isEmpty()){
                    eT_Seeker_NID.setError("Please Enter NID");
                    eT_Seeker_NID.requestFocus();
                }else if (userSeeker_NID.length()>17){
                    eT_Seeker_NID.setError("Invalid NID");
                    eT_Seeker_NID.requestFocus();
                }

                if(userSeeker_Location.isEmpty()){
                    eT_Seeker_Location.setError("Please Enter Your Location");
                    eT_Seeker_Location.requestFocus();
                }else if (userSeeker_Location.length()>17){
                    eT_Seeker_Location.setError("Invalid Location");
                    eT_Seeker_Location.requestFocus();
                }

                if(userSeeker_Address.isEmpty()){
                    eT_Seeker_Address.setError("Please Enter your Address");
                    eT_Seeker_Address.requestFocus();
                } if(userSeeker_Password.isEmpty()){
                    eT_Seeker_Password.setError("Please Enter Password");
                    eT_Seeker_Password.requestFocus();
                }else if (userSeeker_Password.length()<5){
                    eT_Seeker_Password.setError(" Not Strong Password");
                    eT_Seeker_Password.requestFocus();
                }else

                if (!userSeeker_Password.equals(userSeeker_ConfPassword)){

                    AlertDialog.Builder builderMaidReg=new AlertDialog.Builder(RegistrationSeekerActivity.this);
                    builderMaidReg.setTitle("Alert");
                    builderMaidReg.setMessage("Don't Match This Password");
                    builderMaidReg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });

                    builderMaidReg.show();
                    //Toast.makeText(getApplicationContext(),"Don't Match This Password",Toast.LENGTH_LONG).show();
                } else {

                    seeker= new Seeker(userSeeker_FirstName,userSeeker_LastName,userSeeker_UserName,userSeeker_Gender,userSeeker_Age,userSeeker_PhoneNum,userSeeker_NID,userSeeker_Location,userSeeker_Address,userSeeker_Password);
                    dbSeekerController=new DBSeekerController(getApplicationContext());

                    try{
                        inSeekerSuccess=dbSeekerController.insertMaid(seeker);
                    }catch (SQLException e){
                        Toast.makeText(getApplicationContext(),"Insert Fail"+e.toString(),Toast.LENGTH_LONG).show();
                    }
                    if (inSeekerSuccess==true){
                        Toast.makeText(getApplicationContext(),"Insert Successful your Registration",Toast.LENGTH_LONG).show();
                        Intent intentSeekerLog=new Intent(getApplicationContext(),LogInSeekerActivity.class);
                        startActivity(intentSeekerLog);
                    }
                    finish();
                }
            }
        });
    }
}
