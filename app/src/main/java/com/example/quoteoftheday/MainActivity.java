package com.example.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View myView = findViewById(R.id.cl);
        //myView.setBackgroundColor(getResources().getColor(R.color.bg));
        ImageView img1 = findViewById(R.id.imageView2);

        ImageView img2 = findViewById(R.id.imageView4);


        TextView textView;
        Button myquotes;
        myquotes = findViewById(R.id.myquotes);
        textView = findViewById(R.id.textView);
        


        database db = new database(MainActivity.this);
        SQLiteDatabase sqldb = db.getWritableDatabase();

        {
            String a1 = "Choose to be in touch with what is wonderful, refreshing, and healing within yourself and around you.";
            String b1 = "Sunshine is delicious, rain is refreshing, wind braces us up, snow is exhilarating; there is really no such thing as bad weather, only different kinds of good weather.";
            String c1 = "It's always refreshing to step into another time.";
            String d1 = "It's pretty refreshing to be in a situation where the spotlight is on someone else.";
            String e1 = "God's Word refreshes our mind and God's Spirit renews our strength.";
            String f1 = "There is no such thing as bad weather, only different kinds of good weather.";
            String g1 = "I find it refreshing to unplug from it for a while. You kind of forget how deeply you get embedded in it.";
            String h1 = "In the sweetness of friendship let there be laughter, and sharing of pleasures. For in the dew of little things the heart finds its morning and is refreshed.";
            String i1 = "There's something very refreshing about being on stage.";
            String j1 = "Morning glory is the best name, it always refreshes me to see it.";
            String k1 = "One person's crazy is another person's refreshing.";
            String l1 = "Be as eager to break your own will as the thirsty stag is to drink of the refreshing waters.";
            db.addQuote(a1);
            db.addQuote(b1);
            db.addQuote(c1);
            db.addQuote(d1);
            db.addQuote(e1);
            db.addQuote(f1);
            db.addQuote(g1);
            db.addQuote(h1);
            db.addQuote(i1);
            db.addQuote(j1);
            db.addQuote(k1);
            db.addQuote(l1);
        }


        Random random = new Random();
        int randomNumber = random.nextInt(13);
        ArrayList<Model> data= db.fetchQuote();
        String quotee = data.get(randomNumber).quote;
        textView.setText(quotee);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, quotee);
                sendIntent.setType("text/plain");

                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database2 db2 = new database2(MainActivity.this);
                SQLiteDatabase sqldb2 = db2.getWritableDatabase();
                db2.addQuote2(quotee);
                Toast.makeText(MainActivity.this, "Quote has been saved!!", Toast.LENGTH_SHORT).show();

            }
        });

        myquotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, myQuotes.class);

                // Optionally, add extra data
                intent.putExtra("key", "Hello from FirstActivity!");

                // Start the second activity
                startActivity(intent);
            }
        });

    }



}