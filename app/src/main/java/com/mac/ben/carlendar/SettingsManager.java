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

    SettingsManager(Context context){
        mContext = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
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

                try {
                    outputStream = new FileOutputStream(file);
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.close(); // do not forget to close the stream
                    MediaStore.Images.Media.insertImage(mContext.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("logo_settings", 1);
                editor.apply();

                checkPrivateSettings(1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });
    }

    void checkPrivateSettings(int whosCallingMe) { // 0 for opening the app. 1 for download image and save only. 2 for saving in settings.
        switch (whosCallingMe) {
            case 0:
                if (preferences.getInt("logo_settings", 0) == 1) {
                    Bitmap bmImg = BitmapFactory.decodeFile("/storage/emulated/0/logo.png");
                    MainActivity.imageView.setImageBitmap(bmImg);
                }
                if (preferences.getInt("popup_settings", 0) == 1) {
                    int s = preferences.getInt("popup_settings_bkg", 0);
                    MainActivity.mainlayout.setBackgroundResource(s);
                }
                break;
            case 1:
                if (preferences.getInt("logo_settings", 0) == 1) {
                    Bitmap bmImg = BitmapFactory.decodeFile("/storage/emulated/0/logo.png");
                    MainActivity.imageView.setImageBitmap(bmImg);
                }
                break;
            case 2:
                if (preferences.getInt("popup_settings", 0) == 1) {
                    int s = preferences.getInt("popup_settings_bkg", 0);
                    MainActivity.mainlayout.setBackgroundResource(s);
                }
                break;
            default: break;

        }
    }
}
