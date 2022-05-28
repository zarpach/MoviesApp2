package com.example.moviesapp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Rating = itemView.findViewById(R.id.rating);
        description = itemView.findViewById(R.id.description);
    }
}
