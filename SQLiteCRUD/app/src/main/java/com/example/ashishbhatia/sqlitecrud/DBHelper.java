package com.example.ashishbhatia.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ashishbhatia on 10/08/17.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String NAME_NUMBER_TABLE = "NAME_NUMBER";

    // DEfine COlumn
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_NUMBER = "KEY_NUMBER";

    private static final String NAME_NUMBER_TABLE_CREATE =
            "CREATE TABLE " + NAME_NUMBER_TABLE + " (" +
                    KEY_NAME + " TEXT, " +
                    KEY_NUMBER + " TEXT);";

    private static final String WHERE_CLAUSE_NAME = KEY_NAME + " = ?";


    public DBHelper(Context context) {
        super(context, NAME_NUMBER_TABLE, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NAME_NUMBER_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addnameandnumber(String name,String number){
        SQLiteDatabase writer = getWritableDatabase();
        ContentValues newNameNumber = new ContentValues();
        newNameNumber.put(KEY_NAME, name);
        newNameNumber.put(KEY_NUMBER, number);
        writer.insert(NAME_NUMBER_TABLE, null, newNameNumber);
        writer.close();
    }

    public String findNumberFromName(String name){
        SQLiteDatabase reader = getReadableDatabase();
        Cursor cursor = reader.query(NAME_NUMBER_TABLE, new String[]{KEY_NUMBER},
                WHERE_CLAUSE_NAME, new String[]{name}, null, null, null);
        String result;
        if(cursor.moveToFirst()){
            int numberIndex = cursor.getColumnIndex(KEY_NUMBER);
            result= cursor.getString(numberIndex);
        }
        else {
            result = null;
        }

        reader.close();
        return result;

    }
    public void updatenumber(String name,String number){

        SQLiteDatabase writer = getWritableDatabase();
        ContentValues newNameNumber = new ContentValues();
         newNameNumber.put(KEY_NAME, name);
         newNameNumber.put(KEY_NUMBER, number);
         long i = writer.update(NAME_NUMBER_TABLE, newNameNumber,WHERE_CLAUSE_NAME,new String[] {name});
         writer.close();

    }
    public void deleteentry(String name,String number){

        SQLiteDatabase writer = getWritableDatabase();
        writer.delete(NAME_NUMBER_TABLE,WHERE_CLAUSE_NAME,new String[] {name});
        writer.close();
    }
}
