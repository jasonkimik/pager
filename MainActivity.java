package com.example.adithya0797.testingcodebook;



//The code to dynamically add buttons was inspired by this question
// http://stackoverflow.com/questions/1851633/how-to-add-a-button-dynamically-in-android

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;



public class MainActivity extends AppCompatActivity {

    String file_path = "contacts.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void display_contacts(String file_path){
        try {

            //RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            FileReader reader = new FileReader("contacts.txt");
            BufferedReader buffread = new BufferedReader(reader);

            RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_main);
            ScrollView scrollView = (ScrollView)findViewById(R.id.scroller);

            Button home = new Button(this);
            home.setText("HOME");

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tent = new Intent(MainActivity.this, home.class);
                    startActivity(tent);
                }
            });




            while(buffread.readLine() != null){
                //create button for the line
                String temp = buffread.readLine();
                final String[] splitter = temp.split(" ");

                Button button = new Button(this);
                //button.setId(Integer.parseInt(splitter[1]));

                button.setText(splitter[0] + " "+ splitter[1]);

                button.setBackgroundColor(Color.WHITE);

                button.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  Intent intent = new Intent(MainActivity.this, codebook.class);
                                                  intent.putExtra("id", splitter[1] + ".txt");
                                                  startActivity(intent);





                                                  //System.out.print(splitter[0]+ " " + splitter[1]);

                                              }
                                          });

                        layout.addView(button);





            }
            scrollView.addView(layout);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
