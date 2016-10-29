package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ibm.pager__9_10.R;

public class ReceiveMessage extends AppCompatActivity {
    private EditText recip;
    private TextView text;
    String server_url = "http://64.137.191.97/getMsg.php?userNumber=" + recip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        text = (TextView)  findViewById(R.id.textView);


    }
}
