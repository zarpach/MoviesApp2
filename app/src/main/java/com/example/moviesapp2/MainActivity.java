package com.example.moviesapp2;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ArrayList<Item> items;
    NewAdapter newAdapter;
    SearchView searchView;

    Button web;

    private Animation buttonAnim;
    private Button bAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        searchView = findViewById(R.id.searchview);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newAdapter.getFilter().filter(newText);
                return false;
            }
        });

        RecyclerView recyclerView = findViewById(R.id.myrecyclerview);
        newAdapter = new NewAdapter(getApplicationContext(), dataqueue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(newAdapter);

        web=(Button)findViewById(R.id.web_button);
        web.setOnClickListener(v -> {
            Intent web = new Intent(getApplicationContext(), WebActivity2.class);
            startActivity(web);
        });


    }

    private void init(){

        buttonAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.kinopoisk_anim);

        bAnim = findViewById(R.id.web_button);

        bAnim.startAnimation(buttonAnim);



    }

    public ArrayList<Item> dataqueue(){
        ArrayList<Item> holder = new ArrayList<>();

        Item item1 = new Item();
        item1.setTitle("Интерстеллар");
        item1.setGenre("Драма, фантастика");
        item1.setRating("9.2");
        item1.setImage(R.drawable.interstellar_2014);
        holder.add(item1);

        Item item2 = new Item();
        item2.setTitle("Легенда");
        item2.setGenre("Боевик");
        item2.setRating("8.6");
        item2.setImage(R.drawable.legend);
        holder.add(item2);

        Item item3 = new Item();
        item3.setTitle("21-25");
        item3.setGenre("Драма");
        item3.setRating("7.9");
        item3.setImage(R.drawable.tt);
        holder.add(item3);

        Item item4 = new Item();
        item4.setTitle("Гарри Поттер");
        item4.setGenre("Приключения");
        item4.setRating("8.8");
        item4.setImage(R.drawable.harry_potter);
        holder.add(item4);

        Item item5 = new Item();
        item5.setTitle("Семь жизней");
        item5.setGenre("Драма");
        item5.setRating("8.9");
        item5.setImage(R.drawable.seven_pounds);
        holder.add(item5);

        Item item6 = new Item();
        item6.setTitle("Звёздные войны");
        item6.setGenre("Экшен, фантастика");
        item6.setRating("7.5");
        item6.setImage(R.drawable.starwars);
        holder.add(item6);

        Item item7 = new Item();
        item7.setTitle("Джон Уик");
        item7.setGenre("Боевик");
        item7.setRating("8.2");
        item7.setImage(R.drawable.john_wick);
        holder.add(item7);

        Item item8 = new Item();
        item8.setTitle("Властелин Колец");
        item8.setGenre("Приключения");
        item8.setRating("7.1");
        item8.setImage(R.drawable.kingofrings);
        holder.add(item8);

        Item item9 = new Item();
        item9.setTitle("Зеленая книга");
        item9.setGenre("Драма");
        item9.setRating("8.9");
        item9.setImage(R.drawable.greenbook);
        holder.add(item9);

        Item item10 = new Item();
        item10.setTitle("Атака титанов");
        item10.setGenre("Аниме");
        item10.setRating("8.6");
        item10.setImage(R.drawable.titan_attack);
        holder.add(item10);

        return holder;
    }

    public void openProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }


}