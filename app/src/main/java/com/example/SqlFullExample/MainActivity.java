package com.example.SqlFullExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

DataClass dataClass;
SQLClass sqlClass;
Button addbutton;
    ListView list;
    ArrayList<DataClass> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         list = (ListView) findViewById(R.id.listview);
        sqlClass = new SQLClass(this);
         addbutton = (Button)findViewById(R.id.floatingActionButton);





        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddNewWordActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<DataClass> arrayList = sqlClass.displayinformatiofromuser();

        AdapterClass adapterClass =  new AdapterClass(this,R.layout.listview_layout,arrayList);

        list.setAdapter(adapterClass);
    }
}
