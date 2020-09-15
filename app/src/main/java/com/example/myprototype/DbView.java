package com.example.myprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DbView extends AppCompatActivity {
    Databasehelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_view);
        myDb = new Databasehelper(this);
    }
}