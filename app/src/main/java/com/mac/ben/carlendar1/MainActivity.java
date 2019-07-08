package com.mac.ben.carlendar1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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


public class MainActivity extends AppCompatActivity {

     VideoView videoView;
     ProgressBar videoLoadingBar;
     ImageView logoImage;
     RelativeLayout mainLayout;
     static SettingsManager settingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner2 = findViewById(R.id.spinner2);
        videoView = findViewById(R.id.video_view);
        videoLoadingBar = findViewById(R.id.video_progressbar);
        logoImage =  findViewById(R.id.downloadimg);
        mainLayout = findViewById(R.id.main_layout);
        settingsManager = new SettingsManager(this);

        Button dashboardBtn = findViewById(R.id.dashboard_btn);
        ImageButton settingsBtn = findViewById(R.id.settings_btn);

        videoView.setVisibility(View.INVISIBLE);

        if (!checkIfAlreadyhavePermission()) {
            requestForSpecificPermission();
        }

        settingsManager.getAppSettings();

        String[] question1 = {"What do you like to know:", "Check Oil levels", "All about Tire pressure" , "Why is my Air Conditioner low?", "Is my Battery dieing?", "Starting issues", "Prevent Overheating", "Dealing with Overheating", "A Burning smell?", "Why are dashboard lights on?"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, question1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position != 0) {
                    String path = "";
                    videoLoadingBar.setVisibility(View.VISIBLE);
                    switch (position) {
                        case 1: path = getString(R.string.vid1);break;
                        case 2: path = getString(R.string.vid2);break;
                        case 3: path = getString(R.string.vid3);break;
                        case 4: path = getString(R.string.vid4);break;
                        case 5: path = getString(R.string.vid5);break;
                        case 6: path = getString(R.string.vid6);break;
                        case 7: path = getString(R.string.vid7);break;
                        case 8: path = getString(R.string.vid8);break;
                        case 9: path = getString(R.string.vid9);break;
                        default: break;
                    }
                    Uri uri = Uri.parse(path);
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) { videoLoadingBar.setVisibility(View.INVISIBLE); }});
                    videoView.setVideoURI(uri);
                    videoView.requestFocus();
                    videoView.start();
                    videoView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (videoView.isPlaying()) { videoView.pause(); } else { videoView.start(); }
                        }
                    });
                    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) { videoView.setVisibility(View.INVISIBLE); }}); } }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }
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
            }
        });
    }

    public void showDatePicker(View v) {
        DialogFragment newFragment = new FragmentDatePicker();
        newFragment.show(getSupportFragmentManager(), "date picker");
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
        if(requestCode == 101){
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            } // if user deny he won't be able to Download car logo. it will ask again the next time he opens the app.
        }
    }


    public ImageView getImageView(){
        return this.logoImage;
    }

    public RelativeLayout getMainlayout(){
        return this.mainLayout;
    }
}
