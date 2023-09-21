package com.rashid.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String content,getContent;
    EditText editText;
    Button saveBtn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        saveBtn = findViewById(R.id.save);
        preferences = this.getSharedPreferences("com.rashid.mynotesapp", Context.MODE_PRIVATE);


    }
    public void click(View v){
        if(!editText.getText().toString().isEmpty()) {
            if(!editText.getText().toString().equals(getContent)){
            content = editText.getText().toString();
            editor = preferences.edit();
            editor.putString("text",content);
            editor.apply();
            }else{
                Toast.makeText(getApplicationContext(),"You cannot memorize the same text!!!",Toast.LENGTH_SHORT ).show();
            }
        }else {
            Toast.makeText(getApplicationContext(),"Text area is Empty!!!",Toast.LENGTH_SHORT ).show();
        }
    }
    public void  getClick(View v){
        getContent = preferences.getString("text","Not text");
        editText.setText(getContent);
    }
}