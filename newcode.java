package com.example.adithya0797.testingcodebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;


public class newcode extends AppCompatActivity {

    EditText number,meaning;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcode);

        final String name = getIntent().getExtras().getString("name");




        number = (EditText)findViewById(R.id.number);
        meaning = (EditText)findViewById(R.id.meaning);

        done = (Button)findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileWriter add = new FileWriter(name);
                    //BufferedReader addcode = new BufferedReader(add);
                    String numer = number.getText().toString();
                    String message = meaning.getText().toString();
                    add.write(numer + "\t" + message);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        });

    }
}
