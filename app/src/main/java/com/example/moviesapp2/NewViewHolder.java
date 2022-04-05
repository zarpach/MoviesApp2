package com.example.moviesapp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imgView;
    TextView Title;
    TextView Genre;
    TextView Rating;
    NewAdapter.OnMovieListener onMovieListener;

    public NewViewHolder(@NonNull View itemView, NewAdapter.OnMovieListener onMovieListener) {
        super(itemView);
        imgView = itemView.findViewById(R.id.imageView);
        Title = itemView.findViewById(R.id.title);
        Genre = itemView.findViewById(R.id.genre);
        Rating = itemView.findViewById(R.id.rating);
        this.onMovieListener = onMovieListener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onMovieListener.onMovieClick(getAdapterPosition());
    }
}
