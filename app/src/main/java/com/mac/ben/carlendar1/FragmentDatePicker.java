package com.mac.ben.carlendar1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Objects;

public class FragmentDatePicker extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(Objects.requireNonNull(getActivity()), dateSetListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    Toast.makeText(getActivity(), "selected date is " + view.getYear() +
                            " / " + (view.getMonth()+1) +
                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();

                }
            };

    
    // in the future, create template to fill tires/oil/etc... allow him an option to select a template to a specific date.
}
