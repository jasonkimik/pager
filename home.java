package com.example.adithya0797.testingcodebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



    }


    public void addnew(View v){
        Intent addnew = new Intent(home.this, addnew.class);
        startActivity(addnew);

    }

    public void contacts(View v){
        Intent contacts = new Intent(home.this, MainActivity.class);
        startActivity(contacts);
    }
}
