package com.example.sma51.screamscheme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textTitle, textNameQuestion;
    private EditText editTextName;
    private Button buttonStart, buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setOnClickListeners();

    }

    private void wireWidgets() {
        textTitle = (TextView) findViewById(R.id.text_title);
        textNameQuestion = (TextView) findViewById(R.id.text_start_question);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        buttonStart = (Button) findViewById(R.id.button_start);
        buttonName = (Button) findViewById(R.id.button_name);
    }

    private void setOnClickListeners() {
        buttonStart.setOnClickListener(this);
        buttonName.setOnClickListener(this);
    }

    public void setName(){
        String name = editTextName.getText().toString();
        Intent j = new Intent();
        j.putExtra("name", name);
        setResult(Activity.RESULT_OK, j);
        finish();
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_start:
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
                break;
            case R.id.button_name:
                setName();
                break;
        }
    }
}
