package com.example.quotesadminside.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quotesadminside.R;

public class ShowAllQuotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_quotes);
    }

    public void openSuccess(View view) {
        Intent intent = new Intent(ShowAllQuotes.this, SuccessActivity.class);
        startActivity(intent);
    }
}
