package com.mac.ben.carlendar1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity{


    static SettingsManager settingsManager;
    VideoView videoView;
    ProgressBar progressBar;
    ImageView logoImage;
    RelativeLayout mainLayout;
    ImageButton settingsBtn;
    Spinner spinnerVideos;
    Button calendarBtn, storeBtn, dashboardBtn;
    VideoManager videoManager;
    String[] spinnerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if (!checkIfAlreadyhavePermission()) { requestForSpecificPermission(); }

        settingsManager.getAppSettings();



        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, spinnerString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVideos.setAdapter(adapter);
        spinnerVideos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                videoManager.playVideo(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DashboardLightActivity.class));
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.spin));
            }
        });

        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new FragmentDatePicker();
                newFragment.show(getSupportFragmentManager(), "date picker");
            }
        });
        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StoreActivity.class));
            }
        });
    }





    private void init() {
        logoImage = findViewById(R.id.car_module_iv);
        mainLayout = findViewById(R.id.main_layout);
        settingsManager = new SettingsManager(this);
        dashboardBtn = findViewById(R.id.dashboard_btn);
        settingsBtn = findViewById(R.id.settings_btn);
        spinnerVideos = findViewById(R.id.spinner_videos);
        calendarBtn = findViewById(R.id.calendar_btn);
        storeBtn = findViewById(R.id.store_btn);
        progressBar = findViewById(R.id.video_progressbar);
        videoView = findViewById(R.id.video_view);
        videoManager = new VideoManager(this, videoView, progressBar);
        spinnerString = new String[]{"What do you like to know:", "Check Oil levels", "All about Tire pressure", "Why is my Air Conditioner low?", "Is my Battery dieing?", "Starting issues", "Prevent Overheating", "Dealing with Overheating", "A Burning smell?", "Why are dashboard lights on?"};

    }



    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 101) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            } // if user deny he won't be able to Download car logo. it will ask again the next time he opens the app.
        }
    }
}