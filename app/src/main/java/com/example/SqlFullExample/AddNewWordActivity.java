package com.example.SqlFullExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewWordActivity extends AppCompatActivity {

    EditText wordEditText;
    EditText explainingEditText;
    Button addButton;
    SQLClass sqlClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);

        sqlClass = new SQLClass(this);
         wordEditText = (EditText) findViewById(R.id.wordedittext);
         explainingEditText = (EditText) findViewById(R.id.explainingedittext);
        addButton = (Button) findViewById(R.id.addButton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewWord();
            }


        });
    }

    private void AddNewWord() {
        String word = wordEditText.getText().toString();
        String explaining = explainingEditText.getText().toString();

        DataClass dataClass = new DataClass(word,explaining);
        sqlClass.insertword(dataClass);
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        Log.d("errrrrrrrrr","errrrrrrrrrrrrrrrrrrrrrrrrrrror");

    }
}
