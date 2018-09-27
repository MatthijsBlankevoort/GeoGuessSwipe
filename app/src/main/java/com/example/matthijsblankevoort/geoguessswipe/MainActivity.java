package com.example.matthijsblankevoort.geoguessswipe;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    protected boolean isEuropean = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        this.setNewImage();
        imageView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeRight() {
                if (isEuropean) {
                    Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                setNewImage();
            }
            public void onSwipeLeft() {
                if (isEuropean) {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                }
                setNewImage();
            }
        });
    }

    private void setNewImage() {
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.img1_yes_denmark));
        imageView.setTag(R.drawable.img1_yes_denmark);
        this.isEuropean = getResources().getResourceEntryName(R.drawable.img1_yes_denmark).contains("yes");
    }
}
