package com.example.adithya0797.testingcodebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class codebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codebook);

        RelativeLayout codeslayout = (RelativeLayout) findViewById(R.id.activity_codebook);
        ScrollView codesview = (ScrollView) findViewById(R.id.scrolled);
        String id = getIntent().getExtras().getString("id");
        String file_code = "codebooks/" + id + ".txt";


        FileReader codebook = null;
        try {
            codebook = new FileReader(file_code);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }


        BufferedReader codes = new BufferedReader(codebook);

        try {
            while (codes.readLine() != null) {
                String code = codes.readLine();
                String[] maps = code.split("\t");
                TextView text = new TextView(this);
                text.setText("Number: " + maps[0] + "\n" + "Message: " + maps[1] + "___________________________");

                text.setBackgroundColor(Color.WHITE);

                codeslayout.addView(text);
                codesview.addView(codeslayout);

            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}


//layout.removeAllViews();
//
//    try
//
//    {
//        String file_name = "codebooks/" + splitter[1] + ".txt";
//        FileReader codebook = new FileReader(file_name);
//        BufferedReader codes = new BufferedReader(codebook);
//
//        while (codes.readLine() != null) {
//            String code = codes.readLine();
//            Button map = new Button(this);
//
//
//
//        }
//
//
//        } catch (FileNotFoundException e) {
//        e.printStackTrace();
//        } catch (IOException e) {
//        e.printStackTrace();
//        }