package com.example.moviesapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewViewHolder>{

    Context context;
    List<Item> items;
    private NewAdapter.OnMovieListener mOnMovieListener;

    public NewAdapter(Context context, List<Item> items, NewAdapter.OnMovieListener onMovieListener) {
        this.context = context;
        this.items = items;
        this.mOnMovieListener = onMovieListener;
    }

//    public NewAdapter(Context applicationContext, List<Item> items, MainActivity mainActivity) {
//        this.items = items;
//    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new NewViewHolder(view, mOnMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        final Item temp=items.get(position);

        holder.Title.setText(items.get(position).getTitle());
        holder.Genre.setText(items.get(position).getGenre());
        holder.Rating.setText(items.get(position).getRating());
        holder.imgView.setImageResource(items.get(position).getImage());



        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Title", temp.getTitle());
                intent.putExtra("Genre", temp.getGenre());
                intent.putExtra("Rating", temp.getRating());
                intent.putExtra("Image", temp.getImage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.toArray().length;
    }

    public interface OnMovieListener{
        void onMovieClick(int position);
    }

    public void filterList(List<Item> filteredList){
        items = filteredList;
        notifyDataSetChanged();
    }
}
