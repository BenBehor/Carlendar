package com.mac.ben.carlendar1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Spinner backgroundSpinner;
    int backgroundSelected;
    int carModule;
    Button applySettingsBtn;
    Button privacyPolicyBtn;
    SharedPreferences preferences;
    ToggleButton notificationsToggleBtn;
    RadioButton defaultTextRadioBtn;
    RadioButton largeTextRadioBtn;
    Spinner carModuleSpinner;
    MainActivity mMainActivity;



    SettingsActivity(MainActivity mainActivity){
        mMainActivity = mainActivity;
    }

    SettingsActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        backgroundSpinner = findViewById(R.id.background_spinner);
        applySettingsBtn = findViewById(R.id.apply_settings_btn);
        notificationsToggleBtn = findViewById(R.id.toggle_settings_btn);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        defaultTextRadioBtn = findViewById(R.id.default_text_radio_btn);
        largeTextRadioBtn = findViewById(R.id.large_text_radio_btn);
        notificationsToggleBtn.setChecked(true);
        carModuleSpinner = findViewById(R.id.spinner_push);
        privacyPolicyBtn = findViewById(R.id.privacy_policy_btn);



        final String[] backgrounds = {"Select Background:", "Winter" , "Cuba XO", "Big City", "Night Vision", "Spring", "Valley", "Default"};

        ArrayAdapter<String> bkgSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, backgrounds);
        bkgSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backgroundSpinner.setAdapter(bkgSpinnerAdapter);
        backgroundSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch(position) {
                    case 1: backgroundSelected = R.mipmap.background; break;
                    case 2: backgroundSelected = R.mipmap.background3;break;
                    case 3: backgroundSelected = R.mipmap.background4;break;
                    case 4: backgroundSelected = R.mipmap.background5;break;
                    case 5: backgroundSelected = R.mipmap.background6;break;
                    case 6: backgroundSelected = R.mipmap.background7;break;
                    case 7: backgroundSelected = R.mipmap.background2;break;

                    default: break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }});

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int) (displayMetrics.widthPixels * .7),(int) (displayMetrics.heightPixels * .7));

        applySettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                if (backgroundSelected != 0) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("popup_settings", 1);
                    editor.putInt("popup_settings_bkg", backgroundSelected);
                    editor.apply();
                }
                if(defaultTextRadioBtn.isChecked()){
                    // editor.putInt("popup_settings_textsize", 12);
                    Toast.makeText(SettingsActivity.this, "regular text size pressed", Toast.LENGTH_SHORT).show();
                }
                if(largeTextRadioBtn.isChecked()){
                    Toast.makeText(SettingsActivity.this, "large text size pressed", Toast.LENGTH_SHORT).show();
                    //  editor.putInt("popup_settings_textsize", 18);
                }
                if (carModule != 0){
                    MainActivity.settingsManager.downloadAndSaveImage(carModule);
                }
                MainActivity.settingsManager.getAppSettings();
            }
        });

        String[] modules = {"Select Car Module:", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", "Cadillac", "Chevrolet", "Citroen", "Dodge",
                "Ferrari", "Fiat", "Ford", "GMC", "Honda", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", "Lancia", "Land Rover", "Lexus", "Lincoln",
                "Lamborghini", "Maserati", "Mazda", "Mercedes-Benz", "MG", "MINI", "Mitsubishi", "Nissan", "Opel", "Porsche", "Peugeot", "Renault", "Rolls Royce",
                "Subaru","Suzuki", "Seat", "Skoda", "Toyota", "Volkswagen", "Volvo"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(SettingsActivity.this, android.R.layout.simple_list_item_1, modules);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carModuleSpinner.setAdapter(adapter1);
        carModuleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    carModule = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }
        });

        privacyPolicyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        PrivacyPolicyActivity.class);
                startActivity(intent);
            }

        });
    }
}
