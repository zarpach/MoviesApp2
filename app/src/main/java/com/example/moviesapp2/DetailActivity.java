package com.example.moviesapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    List<Item> items;
    ImageView imgView;
    TextView Title, Genre, Rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        imgView = (ImageView)findViewById(R.id.movieImage);
        Genre = (TextView)findViewById(R.id.genreView);
        Rating = (TextView)findViewById(R.id.ratingView);
        Title = (TextView)findViewById(R.id.titleView);


        imgView.setImageResource(getIntent().getIntExtra("Image", 0));
        Title.setText(getIntent().getStringExtra("Title"));
        Genre.setText(getIntent().getStringExtra("Genre"));
        Rating.setText(getIntent().getStringExtra("Rating"));
    }

    public void getBack(View view){
        onBackPressed();
    }
}