package com.example.moviesapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void onClickWeb(View view){
        WebView browser = new WebView(this);
        setContentView(browser);
        browser.loadUrl("https://github.com/rlbk2108/MoviesApp2");

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public void getBack(View view) {
        onBackPressed();
    }

    public void onClick1(View view) {
        ErasFragment f1 = new ErasFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameview, f1);
        ft.commit();
    }


    public void onClick2(View view) {
        ChikasFragment f2 = new ChikasFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameview, f2);
        ft.commit();
    }
}