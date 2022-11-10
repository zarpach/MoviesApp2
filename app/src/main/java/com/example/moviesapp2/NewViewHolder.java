package com.example.moviesapp2;

import static android.content.ContentValues.TAG;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;

public class NewViewHolder extends RecyclerView.ViewHolder {
    ImageView imgView;
    TextView Title;
    TextView Genre;
    TextView Rating;
    TextView description;

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        imgView = itemView.findViewById(R.id.imageView);
        Title = itemView.findViewById(R.id.title);
        Genre = itemView.findViewById(R.id.genre);
        Rating = itemView.findViewById(R.id.ratingViewField);
        description = itemView.findViewById(R.id.description);
    }

}
