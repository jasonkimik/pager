package com.example.ssk.s4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int imageNo[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,
            R.drawable.a5,R.drawable.a6,R.drawable.a8,R.drawable.a9,R.drawable.a10};

    int countImage = imageNo.length;
    int currentImage = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextImage=(Button)findViewById(R.id.btnNext);
        final ImageSwitcher imageSwitcher=(ImageSwitcher) findViewById(R.id.imageChanger);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {

                ImageView imageView = new ImageView (getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;

            }
        });
        nextImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                currentImage++;

                if(currentImage == countImage)
                    countImage = 0;

                imageSwitcher.setImageResource(imageNo[currentImage]);


            }
        });
    }

}

//https://www.youtube.com/watch?v=VG_t-h1Bh0Y
