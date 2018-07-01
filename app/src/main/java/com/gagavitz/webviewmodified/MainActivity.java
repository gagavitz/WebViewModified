package com.gagavitz.webviewmodified;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    private final static String STATE_COUNTER = "counter";
    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        } else {
            webView = findViewById(R.id.wvMain);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("http://lucidys.com");
        }

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    //Create the basics of this (minus if/else) through "Ctrl + O" and searching for "onBackPressed"
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }
}
