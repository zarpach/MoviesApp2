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
    TextView Title, Genre, Rating, Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        imgView = (ImageView)findViewById(R.id.movieImage);
        Genre = (TextView)findViewById(R.id.genreView);
        Rating = (TextView)findViewById(R.id.detailRatingView);
        Title = (TextView)findViewById(R.id.titleView);
        Description = (TextView)findViewById(R.id.description);


        imgView.setImageResource(getIntent().getIntExtra("Image", 0));
        Title.setText(getIntent().getStringExtra("Title"));
        Genre.setText(getIntent().getStringExtra("Genre"));
        Rating.setText(getIntent().getStringExtra("Rating"));
        Description.setText(getIntent().getStringExtra("Description"));
    }

    public void getBack(View view){
        onBackPressed();
    }
}