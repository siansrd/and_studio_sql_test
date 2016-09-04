package com.example.user.sql_test;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 04/09/2016.
 */

public class MainActivity extends AppCompatActivity {

    TextView mDate;
    TextView mWordcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mydatabase = openOrCreateDatabase("WriteTrack",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Journal (Date VARCHAR, Wordcount VARCHAR);");
        mydatabase.execSQL("INSERT INTO Journal VALUES('Jan','500');");


        Cursor resultSet = mydatabase.rawQuery("Select * from Journal",null);
        resultSet.moveToFirst();
        String date = resultSet.getString(0);
        String wordcount = resultSet.getString(1);

        mDate = (TextView) findViewById(R.id.date);
        mDate.setText(date);

        mWordcount = (TextView) findViewById(R.id.wordcount);
        mWordcount.setText(wordcount);



    }
}

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private EditText editDate;
//    private EditText editWordcount;
//    private Button btnAdd;
//    private Button btnView;
//
//    private SQLiteDatabase db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        editDate = (EditText) findViewById(R.id.editDate);
//        editWordcount = (EditText) findViewById(R.id.editWordcount);
//
//        btnAdd = (Button) findViewById(R.id.btnAdd);
//        btnView = (Button) findViewById(R.id.btnView);
//
//        btnAdd.setOnClickListener(this);
//        btnView.setOnClickListener(this);
//    }
//
//
//    protected void createDatabase(){
//        db=openOrCreateDatabase("WriteTrack", Context.MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS journal (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, date VARCHAR, wordcount VARCHAR);");
//    }
//
//    protected void insertIntoDB(){
//        String date = editDate.getText().toString().trim();
//        String wordcount = editWordcount.getText().toString().trim();
//        if(date.equals("") || wordcount.equals("")){
//            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        String query = "INSERT INTO Journal (date, wordcount) VALUES('"+date+"', '"+wordcount+"');";
//        db.execSQL(query);
//        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
//    }
//
//
//
//    @Override
//    public void onClick(View v) {
//        if(v == btnAdd){
//            insertIntoDB();
//        }
//    }
//
//
//
//
//}
