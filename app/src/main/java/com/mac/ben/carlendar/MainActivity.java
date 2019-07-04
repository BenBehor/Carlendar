package com.mac.ben.carlendar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
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

    static RelativeLayout mainlayout; //need to fix
    static ImageView imageView; // need to fix
     SettingsManager settingsManager;
     VideoView videoView;
     ProgressBar videeProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner2 = findViewById(R.id.spinner2);
        mainlayout = findViewById(R.id.main_layout);
        imageView = findViewById(R.id.downloadimg);
        Button dashboardBtn = findViewById(R.id.dashboard_btn);
        videoView = findViewById(R.id.video_view);
        videoView.setVisibility(View.INVISIBLE);
        videeProgressbar = findViewById(R.id.video_progressbar);
        settingsManager = new SettingsManager(this);
        ImageButton settingsBtn = findViewById(R.id.settings_btn);


        //marshmallow and up needs a request to use storage.
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }
            settingsManager.checkPrivateSettings(0);
        }

        String[] question1 = {"What do you like to know:", "Check Oil levels", "All about Tire pressure" , "Why is my Air Conditioner low?", "Is my Battery dieing?", "Starting issues", "Prevent Overheating", "Dealing with Overheating", "A Burning smell?", "Why are dashboard lights on?"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, question1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position != 0) {
                    String path = "";
                    videeProgressbar.setVisibility(View.VISIBLE);
                    switch (position) {
                        case 1: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Foilcheck.mp4?alt=media&token=3eda2ddc-0e98-4e52-b3b9-109b5d86b89a";break;
                        case 2: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fchecktire.mp4?alt=media&token=9c01b5df-7d5e-4fcc-9233-33a41463b73c";break;
                        case 3: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fairconditionerissue.mp4?alt=media&token=f319f19b-ee01-4e1b-b999-648e63904853";break;
                        case 4: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fisbatterydead.mp4?alt=media&token=42d740a5-4759-40dc-8267-ca0d675f60b7";break;
                        case 5: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fstartingtrubble.mp4?alt=media&token=c57cfea4-e441-46e0-8253-823b59d0239d";break;
                        case 6: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fstartingtrubble.mp4?alt=media&token=c57cfea4-e441-46e0-8253-823b59d0239d";break;
                        case 7: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fdealingoverheat.mp4?alt=media&token=ccb525b0-698e-4b3f-9f30-3c5718c52d07";break;
                        case 8: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fburningsmell.mp4?alt=media&token=16af2317-c509-470f-ad19-c8aab646f139";break;
                        case 9: path = "https://firebasestorage.googleapis.com/v0/b/carlendar-car-calendar.appspot.com/o/videos%2Fwhylightson.mp4?alt=media&token=d1da7bbe-4ab3-4545-b2bf-b87776cd3974";break;
                        default: break;
                    }
                    Uri uri = Uri.parse(path);
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) { videeProgressbar.setVisibility(View.INVISIBLE); }});
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
                Intent intent = new Intent(MainActivity.this, DashboardLightActivity.class);
                startActivity(intent);
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
        DialogFragment newFragment = new MyDatePickerFragment();
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
        switch (requestCode) { // need to fix
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) { } else { }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
