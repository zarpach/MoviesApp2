package com.example.moviesapp2;

import androidx.appcompat.app.AppCompatActivity;

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
}