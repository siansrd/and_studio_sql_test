package com.example.user.sql_test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 04/09/2016.
 */
public class ViewEntries extends AppCompatActivity {

    TextView mDate;
    TextView mWordcount;
    TextView mDuration;

    SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entries);


        mDb = openOrCreateDatabase("WriteTrack", MODE_PRIVATE, null);

        Cursor resultSet = mDb.rawQuery("Select * from Journal", null);
        resultSet.moveToFirst();

        mDate = (TextView) findViewById(R.id.date);
        mWordcount = (TextView) findViewById(R.id.wordcount);
        mDuration = (TextView) findViewById(R.id.duration);

        String date = resultSet.getString(0);
        mDate.setText(date);

        String wordcount = resultSet.getString(1);
        mWordcount.setText(wordcount);

        String duration = resultSet.getString(2);
        mDuration.setText(duration);


    }

}


//mSave.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//
//        Cursor resultSet = mDb.rawQuery("Select * from Journal", null);
//        resultSet.moveToFirst();
//        String date = resultSet.getString(0);
//        String wordcount = resultSet.getString(1);
//        String duration = resultSet.getString(2);
//
//
//        Intent intent = new Intent(MainActivity.this, ViewEntries.class);
//        intent.putExtra("date", date);
//        intent.putExtra("wordcount", wordcount);
//        intent.putExtra("duration", duration);
//
//
//        startActivity(intent);
//        }
//
//        });


//mDate = (TextView) findViewById(R.id.date);
//        mDate.setText(date);
//
//        mWordcount = (TextView) findViewById(R.id.wordcount);
//        mWordcount.setText(wordcount);
//
//        mDuration = (TextView) findViewById(R.id.duration);
//        mDuration.setText(duration);