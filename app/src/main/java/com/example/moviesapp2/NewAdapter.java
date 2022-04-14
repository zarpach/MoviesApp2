package com.example.moviesapp2;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class NewAdapter extends RecyclerView.Adapter<NewViewHolder> implements Filterable{

    Context context;
    ArrayList<Item> items;
    ArrayList<Item> backup;

    public NewAdapter(Context context, ArrayList<Item> items) {
        this.items = items;
        this.context = context;
        backup = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new NewViewHolder(view);
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

    @Override
    public Filter getFilter() {
        return itemsFilter;
    }

    Filter itemsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Item> filteredList = new ArrayList<>();

            if (keyword.toString().isEmpty())
                filteredList.addAll(backup);
            else {
                for (Item item : backup)
                {
                    if (item.getTitle().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filteredList.add(item);
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

            @Override
            protected void publishResults (CharSequence charSequence, FilterResults filterResults){
                items.clear();
                items.addAll((ArrayList<Item>)filterResults.values);
                notifyDataSetChanged();
            }
        };
}
