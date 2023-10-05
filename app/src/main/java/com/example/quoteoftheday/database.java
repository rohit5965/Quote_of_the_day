package com.example.quoteoftheday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    private static final String DB_NAME = "quotes";


    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "quotes";

    private static final String id = "id";

    private static final String quote = "quote";


    public database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + quote + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addQuote(String quote) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("quote",quote);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<Model> fetchQuote(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Model> arrayList = new ArrayList<>();

        while(cursor.moveToNext()){
            Model model = new Model();
            model.id = cursor.getInt(0);
            model.quote = cursor.getString(1);
            arrayList.add(model);
        }
        cursor.close();
        return arrayList;
    }

}
