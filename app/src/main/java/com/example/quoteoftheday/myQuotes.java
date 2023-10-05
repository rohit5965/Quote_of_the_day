package com.example.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class myQuotes extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> quote;
    database2 db;
    CustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_quotes);

        View myView = findViewById(R.id.cl);
        myView.setBackgroundColor(getResources().getColor(R.color.bg));

        db = new database2(this);
        quote = new ArrayList<>();
        rv = findViewById(R.id.rv);
        ca = new CustomAdapter(this,quote);
        rv.setAdapter(ca);
        rv.setLayoutManager(new LinearLayoutManager(this));
        displayQuote();

    }

    private void displayQuote() {
        Cursor cursor = db.getQuote();
        if (cursor.getCount()==0){
            return;
        }
        else {
            while (cursor.moveToNext()){
                quote.add(cursor.getString(1));

            }
        }
    }

}