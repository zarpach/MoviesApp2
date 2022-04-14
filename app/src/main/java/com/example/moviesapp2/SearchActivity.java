package com.example.moviesapp2;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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

//public class SearchActivity extends AppCompatActivity implements View.OnClickListener, NewAdapter.OnMovieListener {
//    SearchView searchView;
//    NewAdapter newAdapter;
//    ArrayList<Item> items;
//    RecyclerView recyclerView;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        searchView = findViewById(R.id.searchinput);
//        searchView.clearFocus();
//
//
//        initRV();
//
//        SearchView.OnQueryTextListener queryTextListener = (new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(@Nullable String newText) {
//                filter(newText);
//                return false;
//            }
//        });
//        searchView.setOnQueryTextListener(queryTextListener);
//    }
//
//    private void filter(String text) {
//        // creating a new array list to filter our data.
//        ArrayList<Item> filteredlist = new ArrayList<>();
//
//        // running a for loop to compare elements.
//        for (Item item : items) {
//            // checking if the entered string matched with any item of our recycler view.
//            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
//                // if the item is matched we are
//                // adding it to our filtered list.
//                filteredlist.add(item);
//            }
//        }
//        if (filteredlist.isEmpty()) {
//            // if no item is added in filtered list we are
//            // displaying a toast message as no data found.
//            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
//        } else {
//            // at last we are passing that filtered
//            // list to our adapter class.
//            newAdapter.setFilteredList(filteredlist);
//        }
//    }
//
//    public void initRV(){
//        ArrayList<Item> items = new ArrayList<Item>();
//
//        RecyclerView recyclerView = findViewById(R.id.movielist);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(new NewAdapter(getApplicationContext(), items, this));
//
//        items.add(new Item("Звездные воины", "Фэнтези", "7.1", R.drawable.starwars));
//        items.add(new Item("Гарри Поттер", "Приключения", "9.0", R.drawable.harry_potter));
//        items.add(new Item("Интерстеллар", "Драма", "10.0", R.drawable.interstellar_2014));
//        items.add(new Item("Зеленая книга", "Драма", "8.7", R.drawable.greenbook));
//        items.add(new Item("Джон Уик", "Боевик", "8.1", R.drawable.john_wick));
//
//        items.add(new Item("Семь жизней", "Драма", "7.1", R.drawable.seven_pounds));
//        items.add(new Item("Легенда", "Боевик", "9.0", R.drawable.legend));
//        items.add(new Item("Триггер", "Драма", "10.0", R.drawable.legend));
//        items.add(new Item("Властелин колец", "Приключения", "8.7", R.drawable.kingofrings));
//        items.add(new Item("25-21", "Дорама", "8.1", R.drawable.tt));
//
//    }
//    public void getBack(View view) {
//        onBackPressed();
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
//    @Override
//    public void onMovieClick(int position) {
//
//    }
//}