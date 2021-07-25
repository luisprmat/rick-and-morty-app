package co.com.luisprmat.training.rickandmortyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivTest = findViewById(R.id.ivTest);

        Glide.with(this).load("https://goo.gl/gEgYUd").into(ivTest);
    }
}