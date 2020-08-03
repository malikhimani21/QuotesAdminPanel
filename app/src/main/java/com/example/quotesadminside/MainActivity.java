package com.example.quotesadminside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quotesadminside.insertQuotes.InsertQuotesActivity;
import com.example.quotesadminside.view.ShowAllQuotes;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openInsertQuotesActivity(View view) {
        Intent intent = new Intent(MainActivity.this, InsertQuotesActivity.class);
        startActivity(intent);

    }

    public void openViewQuotesActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ShowAllQuotes.class);
        startActivity(intent);
    }
}
