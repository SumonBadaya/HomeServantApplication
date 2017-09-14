package com.example.user.homeservantapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 3/21/2017.
 */

public class DBMaidController extends SQLiteOpenHelper {
    public static int VERSION =1;
    public static String DATABASE_NAME="maid_servantDB.db";
    public static String TABLE_NAME="maid_servant_table";

    public static String COLUMN_MAID_FIRST_NAME="maid_firstname";
    public static String COLUMN_MAID_LAST_NAME="maid_lastname";
    public static String COLUMN_MAID_USER_NAME="maid_username";
    public static String COLUMN_MAID_GENDER="maid_gender";
    public static String COLUMN_MAID_AGE="maid_age";
    public static String COLUMN_MAID_LOCATION="maid_location";
    public static String COLUMN_MAID_PHONE_NUMBER="maid_phone";
    public static String COLUMN_MAID_NID="maid_nid";
    public static String COLUMN_MAID_ADDRESS="maid_address";
    public static String COLUMN_MAID_PASSWORD="maid_password";




    SQLiteDatabase db_Maid;
    Cursor cursor_Maid;

    public String QUERY_CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"( ID integer,"+COLUMN_MAID_FIRST_NAME+" TEXT, "+COLUMN_MAID_LAST_NAME+" TEXT, "+COLUMN_MAID_USER_NAME+" TEXT, "+COLUMN_MAID_GENDER+" TEXT, "+COLUMN_MAID_AGE+" TEXT, "+COLUMN_MAID_LOCATION+" TEXT, "+COLUMN_MAID_PHONE_NUMBER+" TEXT, "+COLUMN_MAID_NID+" TEXT, "+COLUMN_MAID_ADDRESS+" TEXT, "+COLUMN_MAID_PASSWORD+" TEXT )";
    public String QUERY_DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+"";

    public DBMaidController(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE_TABLE);

    }

    public boolean insertMaid(Maid maid){
        boolean inMaidSuccess=false;
        long maidSuccess=0;

        ContentValues contentValues_Maid=new ContentValues();

        contentValues_Maid.put(COLUMN_MAID_FIRST_NAME,maid.getMaidFirstName());
        contentValues_Maid.put(COLUMN_MAID_LAST_NAME,maid.getMaidLastName());
        contentValues_Maid.put(COLUMN_MAID_USER_NAME,maid.getMaidUserName());
        contentValues_Maid.put(COLUMN_MAID_PHONE_NUMBER,maid.getMaidPhoneNumber());
        contentValues_Maid.put(COLUMN_MAID_NID,maid.getMaidNID());
        contentValues_Maid.put(COLUMN_MAID_ADDRESS,maid.getMaidAddress());
        contentValues_Maid.put(COLUMN_MAID_PASSWORD,maid.getMaidPassword());
        contentValues_Maid.put(COLUMN_MAID_GENDER,maid.getMaidGender());
        contentValues_Maid.put(COLUMN_MAID_AGE,maid.getMaidAge());
        contentValues_Maid.put(COLUMN_MAID_LOCATION,maid.getMaidLocation());



        db_Maid=getWritableDatabase();
        maidSuccess=db_Maid.insertOrThrow(TABLE_NAME,null,contentValues_Maid);

        if (maidSuccess!=-1){
            inMaidSuccess=true;
        }
        db_Maid.close();
        return inMaidSuccess;

    }
/***


    public void insertDataImage(byte[] image){
        SQLiteDatabase database=getWritableDatabase();
        String sql=COLUMN_MAID_IMAGE_KEY;
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();

        statement.bindBlob(1,image);

        statement.executeInsert();
    }



    public Cursor getData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql, null);
    }
***/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(QUERY_DROP_TABLE);

    }

    public void checkMaidValue(String ckeck_Maid_UserName, String check_Maid_Password){
        db_Maid=this.getReadableDatabase();
        cursor_Maid=db_Maid.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+COLUMN_MAID_USER_NAME+" =? AND "+COLUMN_MAID_PASSWORD+" =? ",new String[]{ckeck_Maid_UserName,check_Maid_Password});

    }




    // Get the image from SQLite DB
    // We will just get the last image we just saved for convenience...
    /****
    public byte[] retreiveImageFromDB() {
        Cursor cur = db_Maid.query(true, TABLE_NAME, new String[]{COLUMN_MAID_IMAGE,},
                null, null, null, null,
                COLUMN_MAID_IMAGE_KEY + " DESC", "1");
        if (cur.moveToFirst()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(COLUMN_MAID_IMAGE_KEY));
            cur.close();
            return blob;
        }
        cur.close();
        return null;
    } ****/
}

