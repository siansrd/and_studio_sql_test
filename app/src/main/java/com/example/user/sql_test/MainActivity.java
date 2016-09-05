package com.example.user.sql_test;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 04/09/2016.
 */

public class MainActivity extends AppCompatActivity {

    EditText mDate;
    EditText mWordcount;
    EditText mDuration;
    Button mSave;

    SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate  = (EditText) findViewById(R.id.editDate);
        mWordcount  = (EditText) findViewById(R.id.editWordcount);
        mDuration  = (EditText) findViewById(R.id.editDuration);
        mSave   = (Button) findViewById(R.id.save);

//     TO DELETE THE DATABASE
        this.deleteDatabase("WriteTrack");

        mDb = openOrCreateDatabase("WriteTrack",MODE_PRIVATE,null);
        mDb.execSQL("CREATE TABLE IF NOT EXISTS Journal (Date VARCHAR, Wordcount INTEGER, Duration INTEGER);");


        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date = mDate.getText().toString();
                Integer wordcount = Integer.parseInt(mWordcount.getText().toString());
                Integer duration = Integer.parseInt(mDuration.getText().toString());
//                Integer duration = mDuration.getText();


                mDb.execSQL("INSERT INTO Journal (date, wordcount, duration) VALUES('"+date+"', '"+wordcount+"', '"+duration+"');");
                Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();

            }

        });

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.view_entries) {
            Intent intent = new Intent(MainActivity.this, ViewEntries.class);
//                intent.putExtra("answer", answer);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

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
