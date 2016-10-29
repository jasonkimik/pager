package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibm.pager__9_10.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//connect the Codebook activity to this activity.

public class compose extends AppCompatActivity
{
    private EditText recip;
    private Button   sd;
    private Button   codeBook;

    private String num;
    private String sender;

    String server_url = "http://64.137.191.97/sendMsg.php?userNumber="+ recip+"&from="+sender+"&msgToSend="+num;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        Intent intent = getIntent();
        num = intent.getStringExtra("num");

        recip    = (EditText)findViewById(R.id.recipient);
        sd       = (Button)findViewById(R.id.sending);
        codeBook = (Button)findViewById(R.id.codeBook);


        sd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                final RequestQueue requestQueue = Volley.newRequestQueue(compose.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                recip.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        recip.setText("Something went wrong....");
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                });
                requestQueue.add(stringRequest);

                if(recip.getText() != null)
                {
                    recip.setText("Message sent");
                }


            }
        });

        codeBook.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //should redirect user to the his codebook activityu, using intents. To be implemented later.
            }
        });

    }
}
