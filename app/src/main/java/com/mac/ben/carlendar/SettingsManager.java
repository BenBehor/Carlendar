package com.mac.ben.carlendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class SettingsManager{

    private SharedPreferences preferences;
    private Context mContext;
    private MainActivity mMainActivity;

    SettingsManager(MainActivity mainActivity){
        mMainActivity = mainActivity;
        mContext = mainActivity.getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(mainActivity.getApplicationContext());
    }


    void downloadAndSaveImage(Integer position) {
        StorageReference ref = FirebaseStorage.getInstance().getReference().child("logos").child(position.toString() + ".png");
        final long ONE_MEGABYTE = 1024 * 1024;
        ref.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                OutputStream outputStream;
                File file = new File(Environment.getExternalStorageDirectory() + File.separator + "logo.png");
                System.out.println("errr + successsssssss" );

                try {
                    outputStream = new FileOutputStream(file);
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.close(); // do not forget to close the stream
                    MediaStore.Images.Media.insertImage(mContext.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());


                    MainActivity.settingsManager.mMainActivity.logoImage.setImageBitmap(bmp);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("logo_settings", 1);
                editor.apply();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });
    }


    void getAppSettings(){
        if (preferences.getInt("logo_settings", 0) == 1) { // 1 for data exist.
            Bitmap bmImg = BitmapFactory.decodeFile("/storage/emulated/0/logo.png");
            MainActivity.settingsManager.mMainActivity.logoImage.setImageBitmap(bmImg);
        }
        if (preferences.getInt("popup_settings", 0) == 1) {
            int s = preferences.getInt("popup_settings_bkg", 0);
            MainActivity.settingsManager.mMainActivity.mainLayout.setBackgroundResource(s);
        }
        if (preferences.getInt("popup_settings", 0) == 1) {
            int s = preferences.getInt("popup_settings_bkg", 0);
            MainActivity.settingsManager.mMainActivity.mainLayout.setBackgroundResource(s);
        }

    }
}
