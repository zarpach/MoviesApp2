package com.example.moviesapp2;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, NewAdapter.OnMovieListener {
    SearchView searchView;
    NewAdapter newAdapter;
    List<Item> items;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        List<Item> items = new ArrayList<Item>();
        searchView = findViewById(R.id.searchinput);
        searchView.clearFocus();
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(@Nullable String newText) {
                try {
                    newText = newText.toLowerCase();
                    List<Item> newList = new ArrayList<>();
                    for (Item item : items) {
                        String title = item.getTitle().toLowerCase();
                        if (title.contains(newText)) {
                            newList.add(item);
                        }
                    }
                    newAdapter.setFilteredList(newList);

                    return true;
                } catch (Exception d) {
                    Log.d(TAG, "Error" + d);
                }
                return false;
            }
        };

        searchView.setOnQueryTextListener(queryTextListener);

        RecyclerView recyclerView = findViewById(R.id.movielist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new NewAdapter(getApplicationContext(), items, this));

        items.add(new Item("Звездные воины", "Фэнтези", "7.1", R.drawable.starwars));
        items.add(new Item("Гарри Поттер", "Приключения", "9.0", R.drawable.harry_potter));
        items.add(new Item("Интерстеллар", "Драма", "10.0", R.drawable.interstellar_2014));
        items.add(new Item("Зеленая книга", "Драма", "8.7", R.drawable.greenbook));
        items.add(new Item("Джон Уик", "Боевик", "8.1", R.drawable.john_wick));

        items.add(new Item("Семь жизней", "Драма", "7.1", R.drawable.seven_pounds));
        items.add(new Item("Легенда", "Боевик", "9.0", R.drawable.legend));
        items.add(new Item("Триггер", "Драма", "10.0", R.drawable.legend));
        items.add(new Item("Властелин колец", "Приключения", "8.7", R.drawable.kingofrings));
        items.add(new Item("25-21", "Дорама", "8.1", R.drawable.tt));
    }

    public void getBack(View view) {
        onBackPressed();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onMovieClick(int position) {

    }
}