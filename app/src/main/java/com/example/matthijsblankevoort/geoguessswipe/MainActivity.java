package com.example.matthijsblankevoort.geoguessswipe;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    protected boolean isEuropean = false;

    private int[] imageArray = new int[] {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand,
    };

    private int imageIndex = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);

        this.setNewImage();

        imageView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeRight() {
                if (isEuropean) {
                    Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                imageIndex++;
                setNewImage();
            }
            public void onSwipeLeft() {
                if (isEuropean) {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                }
                imageIndex++;
                setNewImage();
            }
        });
    }

    private void setNewImage() {
        if (this.imageIndex > this.imageArray.length - 1) {
            this.imageIndex = 0;
        }

        this.imageView.setImageDrawable(getResources().getDrawable(imageArray[imageIndex]));
        this.imageView.setTag(imageArray[imageIndex]);
        this.isEuropean = getResources().getResourceEntryName(imageArray[imageIndex]).contains("yes");
    }
}
