package com.example.adithya0797.testingcodebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;


//add this to contacts.txt

public class addnew extends AppCompatActivity {

    Button submit;
    EditText name;
    EditText pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew);

        submit = (Button)findViewById(R.id.submit);
        name = (EditText)findViewById(R.id.name);
        pin = (EditText)findViewById(R.id.PIN);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname = pin.getText().toString();

                File file = new File("codebooks/"+ newname + ".txt");
                try {
                    if(file.createNewFile() == true){
                        Intent addcode = new Intent(addnew.this, newcode.class);
                        addcode.putExtra("name", "codebooks/"+ newname + ".txt");
                        startActivity(addcode);



                        FileWriter contact = new FileWriter("contacts.txt");
                        //BufferedReader addcode = new BufferedReader(add);
                        String names = name.getText().toString();
                        String digits = pin.getText().toString();
                        contact.write(names + "\t" + digits);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


    }


}
