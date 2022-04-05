package com.example.moviesapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewAdapter.OnMovieListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.myrecyclerview);
        List<Item> items = new ArrayList<Item>();


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

    @Override
    public void onMovieClick(int position) {

    }

    public void openProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }


}