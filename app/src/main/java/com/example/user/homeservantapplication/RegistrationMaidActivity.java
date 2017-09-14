package com.example.user.homeservantapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RegistrationMaidActivity extends AppCompatActivity {

    EditText eT_Maid_First_Name, eT_Maid_Last_Name, eT_Maid_UserName,eT_Maid_Gender,eT_Maid_Age,eT_Maid_Location, eT_Maid_PhoneNumber, eT_Maid_NID, eT_Maid_Address, eT_Maid_Password, eT_Maid_ConfirmPassword;
    Button button_Next_MaidReg,profile_choose_button;

    Maid maid;
    DBMaidController dbMaidController;
    boolean inMaidSuccess=false,selectImage=false;

    byte[] imageByte;

    MyDataBaseProfile db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_maid);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        db=new MyDataBaseProfile(this);

        eT_Maid_First_Name=(EditText)findViewById(R.id.eT_Maid_First_Name);
        eT_Maid_Last_Name=(EditText)findViewById(R.id.eT_Maid_Last_Name);
        eT_Maid_UserName=(EditText)findViewById(R.id.eT_Maid_UserName);
        eT_Maid_Gender=(EditText)findViewById(R.id.eT_Maid_Gender);
        eT_Maid_Age=(EditText)findViewById(R.id.eT_Maid_Age);
        eT_Maid_Location=(EditText)findViewById(R.id.eT_Maid_Location);
        eT_Maid_PhoneNumber=(EditText)findViewById(R.id.eT_Maid_PhoneNumber);
        eT_Maid_NID=(EditText)findViewById(R.id.eT_Maid_NID);
        eT_Maid_Address=(EditText)findViewById(R.id.eT_Maid_Address);
        eT_Maid_Password=(EditText)findViewById(R.id.eT_Maid_Password);
        eT_Maid_ConfirmPassword=(EditText)findViewById(R.id.eT_Maid_ConfirmPassword);
        profile_choose_button=(Button)findViewById(R.id.MaidprofileImage);


        button_Next_MaidReg=(Button)findViewById(R .id.button_Next_MaidReg);
        button_Next_MaidReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMaid_FirstName=eT_Maid_First_Name.getText().toString();
                String userMaid_LastName=eT_Maid_Last_Name.getText().toString();
                String userMaid_UserName=eT_Maid_UserName.getText().toString();
                String userMaid_Gender=eT_Maid_Gender.getText().toString();
                String userMaid_Age=eT_Maid_Age.getText().toString();
                String userMaid_Location=eT_Maid_Location.getText().toString();
                String userMaid_PhoneNum=eT_Maid_PhoneNumber.getText().toString();
                String userMaid_NID=eT_Maid_NID.getText().toString();
                String userMaid_Address=eT_Maid_Address.getText().toString();
                String userMaid_Password=eT_Maid_Password.getText().toString();
                String userMaid_ConfPassword=eT_Maid_ConfirmPassword.getText().toString();

                if (userMaid_FirstName.isEmpty()){
                    eT_Maid_First_Name.setError("Please Enter First Name");
                    eT_Maid_First_Name.requestFocus();
                }else if(userMaid_FirstName.length()>15){
                    eT_Maid_First_Name.setError("Remove long First Name");
                    eT_Maid_First_Name.requestFocus();
                }
                if(userMaid_LastName.isEmpty()){
                    eT_Maid_Last_Name.setError("Please Enter Last Name");
                    eT_Maid_Last_Name.requestFocus();
                }else if (userMaid_LastName.length()>10){
                    eT_Maid_Last_Name.setError("Remove long Last Name");
                    eT_Maid_Last_Name.requestFocus();
                }
                if(userMaid_UserName.isEmpty()){
                    eT_Maid_UserName.setError("Please Enter User Name");
                    eT_Maid_UserName.requestFocus();
                }else if (userMaid_UserName.length()>15){
                    eT_Maid_UserName.setError("Remove long User Name");
                    eT_Maid_UserName.requestFocus();
                }

                if(userMaid_Gender.isEmpty()){
                    eT_Maid_Gender.setError("Please Enter Female or Male");
                    eT_Maid_Gender.requestFocus();
                }else if (userMaid_Gender.length()>7){
                    eT_Maid_UserName.setError("Invalid Enter Female or Male");
                    eT_Maid_UserName.requestFocus();
                }

                if(userMaid_Age.isEmpty()){
                    eT_Maid_Age.setError("Please Enter your age");
                    eT_Maid_Age.requestFocus();
                }else if (userMaid_Age.length()>3){
                    eT_Maid_Age.setError("Invalid Age");
                    eT_Maid_Age.requestFocus();
                }

                if(userMaid_PhoneNum.isEmpty()){
                    eT_Maid_PhoneNumber.setError("Please Enter Phone Number");
                    eT_Maid_PhoneNumber.requestFocus();
                }else if (userMaid_PhoneNum.length()>11){
                    eT_Maid_PhoneNumber.setError("Invalid Phone Number");
                    eT_Maid_PhoneNumber.requestFocus();
                }
                if(userMaid_NID.isEmpty()){
                    eT_Maid_NID.setError("Please Enter NID");
                    eT_Maid_NID.requestFocus();
                }else if (userMaid_NID.length()>17){
                    eT_Maid_NID.setError("Invalid NID");
                    eT_Maid_NID.requestFocus();
                }

                if(userMaid_Location.isEmpty()){
                    eT_Maid_Location.setError("Please Enter Your Location");
                    eT_Maid_Location.requestFocus();
                }else if (userMaid_Location.length()>17){
                    eT_Maid_Location.setError("Invalid Location");
                    eT_Maid_Location.requestFocus();
                }

                if(userMaid_Address.isEmpty()){
                    eT_Maid_Address.setError("Please Enter your Address");
                    eT_Maid_Address.requestFocus();
                }
                if(userMaid_Password.isEmpty()){
                    eT_Maid_Password.setError("Please Enter Password");
                    eT_Maid_Password.requestFocus();
                }else if (userMaid_Password.length()<5){
                    eT_Maid_Password.setError(" Not Strong Password");
                    eT_Maid_Password.requestFocus();
                }

                else if (!userMaid_Password.equals(userMaid_ConfPassword)) {
                    AlertDialog.Builder builderMaidReg = new AlertDialog.Builder(RegistrationMaidActivity.this);
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
                    maid=new Maid(userMaid_FirstName,userMaid_LastName,userMaid_UserName,userMaid_Gender,userMaid_Age,userMaid_PhoneNum,userMaid_NID,userMaid_Location,userMaid_Address,userMaid_Password);
                    dbMaidController=new DBMaidController(getApplicationContext());


                    try {
                        inMaidSuccess=dbMaidController.insertMaid(maid);
                        if(imageByte==null)
                            Log.e("imagebyte ","null");
                        if(inMaidSuccess && selectImage && db.createAndPass(userMaid_UserName,userMaid_Password,imageByte)) {
                            selectImage=false;
                            Log.e("Stored", " ok");

                        }

                    }catch (SQLException e){
                        Toast.makeText(getApplicationContext(),"Insert Fail"+e.toString(),Toast.LENGTH_LONG).show();
                    }

                    if(inMaidSuccess==true ){
                        Toast.makeText(getApplicationContext(),"Insert Successful your Registration",Toast.LENGTH_LONG).show();

                        Intent intentMaidLog=new Intent(getApplicationContext(),LogInMaidServandActivity.class);
                        startActivity(intentMaidLog);

                    }
                    finish();
                }

            }
        });

        profile_choose_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPic();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            Uri imageUri=data.getData();

            InputStream inputStream=null;

            try {
                inputStream=getContentResolver().openInputStream(imageUri);
                Bitmap image= BitmapFactory.decodeStream(inputStream);
                imageByte=getBytes(image);
                selectImage=true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
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
