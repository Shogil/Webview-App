package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    ProgressBar myProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.myWebView);
        myProgressBar= findViewById(R.id.myProgressBar);

        myWebView.loadUrl("https://www.google.com");
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                myProgressBar.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                   myProgressBar.setVisibility(View.VISIBLE);

                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                  myProgressBar.setVisibility(View.GONE);

                super.onPageFinished(view, url);
            }
        });


    }
}