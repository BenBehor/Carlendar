package com.mac.ben.carlendar1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyPolicyActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        web =findViewById(R.id.webView);
        web.loadUrl("https://firebasestorage.googleapis.com/v0/b/carlendar-1.appspot.com/o/privacy_policy.md?alt=media&token=d34f9cf7-8c54-4f0e-a8bc-7cabeb097eca");
    }
}
