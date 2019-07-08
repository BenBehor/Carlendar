package com.mac.ben.carlendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyPolicyActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        web =(WebView)findViewById(R.id.
                webView);
        web.loadUrl("https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/privacy_policy.md?alt=media&token=70979bd6-6780-4a64-9513-ae5b9acd8ffa");
    }
}
