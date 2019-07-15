package com.mac.ben.carlendar1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class PrivacyPolicyActivity extends AppCompatActivity {

    WebView webView;
    Button closeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);



        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int) (displayMetrics.widthPixels * .7),(int) (displayMetrics.heightPixels * .7));

        webView = findViewById(R.id.pp_web_view);
        closeBtn = findViewById(R.id.pp_btn_close);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        webView.setBackgroundColor(getColor(R.color.colorTransparent));
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/carlendar-1.appspot.com/o/privacy_policy.md?alt=media&token=d34f9cf7-8c54-4f0e-a8bc-7cabeb097eca");
    }
}
