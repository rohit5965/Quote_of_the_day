package com.example.quoteoftheday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database2 extends SQLiteOpenHelper {
    private static final String DB_NAME = "myquotes";


    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "myquotes";

    private static final String id = "id";

    private static final String myquote = "myquote";

    public database2(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + myquote + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addQuote2(String myquote) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("myquote",myquote);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public Cursor getQuote(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM myquotes", null);
        return cursor;
    }

}
