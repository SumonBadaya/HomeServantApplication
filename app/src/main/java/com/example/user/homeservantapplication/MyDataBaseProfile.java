package com.example.user.homeservantapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDataBaseProfile extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="MY_DATABASEPROFILE.db";

    public MyDataBaseProfile(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE t (u TEXT,p text,i BLOB)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS t");
        onCreate(db);
    }

    public boolean createAndPass(String userMaid_UserName,String pass,byte[] image)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("u",userMaid_UserName);
        contentValues.put("p",pass);
        contentValues.put("i",image);

        try{
            sqLiteDatabase.insert("t",null,contentValues);
        }catch (Exception e) {
            return false;
        }
        return true;

    }

    public Cursor display(String user_name,String pass)
    {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        try {
            user_name = "'"+user_name+"'";
            pass = "'"+pass+"'";
            Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM t WHERE u like "+user_name+" AND p like "+pass,null);

            if(cursor.getCount()>0) {
                return cursor;
            }
            return null;

        }catch (Exception e){
            Log.e("display ","Error");
            return null;
        }

    }

}