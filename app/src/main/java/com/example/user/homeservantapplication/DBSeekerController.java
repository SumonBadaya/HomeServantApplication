package com.example.user.homeservantapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 3/21/2017.
 */

public class DBSeekerController extends SQLiteOpenHelper {
    public static int VERSION =1;
    public static String DATABASE_NAME="maid_seekerDB.db";
    public static String TABLE_NAME="maid_seeker_table";

    public static String COLUMN_SEEKER_FIRST_NAME="seeker_firstname";
    public static String COLUMN_SEEKER_LAST_NAME="seeker_lastname";
    public static String COLUMN_SEEKER_USER_NAME="seeker_username";
    public static String COLUMN_SEEKER_GENDER="seeker_gender";
    public static String COLUMN_SEEKER_AGE="seeker_age";
    public static String COLUMN_SEEKER_LOCATION="seeker_location";
    public static String COLUMN_SEEKER_PHONE_NUMBER="seeker_phone";
    public static String COLUMN_SEEKER_NID="seeker_nid";
    public static String COLUMN_SEEKER_ADDRESS="seeker_address";
    public static String COLUMN_SEEKER_PASSWORD="seeker_password";



    SQLiteDatabase db_seeker;
    Cursor cursor_seeker;

    public String QUERY_CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( ID INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_SEEKER_FIRST_NAME+" TEXT, "+COLUMN_SEEKER_LAST_NAME+" TEXT, "+COLUMN_SEEKER_USER_NAME+" TEXT, "+COLUMN_SEEKER_GENDER+" TEXT, "+COLUMN_SEEKER_AGE+" TEXT, "+COLUMN_SEEKER_LOCATION+" TEXT, "+COLUMN_SEEKER_PHONE_NUMBER+" TEXT, "+COLUMN_SEEKER_NID+" TEXT, "+COLUMN_SEEKER_ADDRESS+" TEXT, "+COLUMN_SEEKER_PASSWORD+" TEXT )";
    public String QUERY_DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+"";

    public DBSeekerController(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE_TABLE);

    }

    public boolean insertMaid(Seeker seeker){
        boolean inSeekerSuccess=false;
        long seekerSuccess=0;

        ContentValues contentValues_Seeker=new ContentValues();

        contentValues_Seeker.put(COLUMN_SEEKER_FIRST_NAME,seeker.getSeekerFirstName());
        contentValues_Seeker.put(COLUMN_SEEKER_LAST_NAME,seeker.getSeekerLastName());
        contentValues_Seeker.put(COLUMN_SEEKER_USER_NAME,seeker.getSeekerUserName());
        contentValues_Seeker.put(COLUMN_SEEKER_GENDER,seeker.getSeekerGender());
        contentValues_Seeker.put(COLUMN_SEEKER_AGE,seeker.getSeekerAge());
        contentValues_Seeker.put(COLUMN_SEEKER_PHONE_NUMBER,seeker.getSeekerPhoneNumber());
        contentValues_Seeker.put(COLUMN_SEEKER_NID,seeker.getSeekerNID());
        contentValues_Seeker.put(COLUMN_SEEKER_LOCATION,seeker.getSeekerLocation());
        contentValues_Seeker.put(COLUMN_SEEKER_ADDRESS,seeker.getSeekerAddress());
        contentValues_Seeker.put(COLUMN_SEEKER_PASSWORD,seeker.getSeekerPassword());


        db_seeker=getWritableDatabase();
        seekerSuccess=db_seeker.insertOrThrow(TABLE_NAME,null,contentValues_Seeker);

        if (seekerSuccess!=-1){
            inSeekerSuccess=true;
        }
        db_seeker.close();
        return inSeekerSuccess;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(QUERY_DROP_TABLE);

    }

    public void checkSeekerValue(String ckeck_Seeker_UserName, String check_Seeker_Password){
        db_seeker=this.getReadableDatabase();
        cursor_seeker=db_seeker.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+COLUMN_SEEKER_USER_NAME+" =? AND "+COLUMN_SEEKER_PASSWORD+" =? ",new String[]{ckeck_Seeker_UserName,check_Seeker_Password});

    }
}

