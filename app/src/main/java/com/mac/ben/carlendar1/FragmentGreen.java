package com.mac.ben.carlendar1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FragmentGreen extends Fragment {

    private List<RCVItem> listContact = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_green, container, false);
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_green);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listContact, 3);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        listContact.add(new RCVItem(R.drawable.engine_start_stop_symbol_in_green,"Engine Stop","Indicates the engine start / stop function is in operation."));
        listContact.add(new RCVItem(R.drawable.interior_light_symbol_in_green,"Interior Light","Indicates that the vehicles interior lights are on."));
        listContact.add(new RCVItem(R.drawable.car_charging_symbol_in_green,"Charging","Indicates that the vehicle is connected to electrical charging station"));
        listContact.add(new RCVItem(R.drawable.interior_light_warning_in_green,"Interior Light","Indicates that an interior light is on."));
        listContact.add(new RCVItem(R.drawable.car_key_symbol_in_green,"Car Key","Indicates the vehicle key is in the ignition"));
        listContact.add(new RCVItem(R.drawable.ev_mode_symbol_in_green,"EV","Indicates the vehicle is is EV (electric vehicle) mode."));
        listContact.add(new RCVItem(R.drawable.side_lights_symbol_in_green,"Side Lights","Indicates that the sidelights are on."));
        listContact.add(new RCVItem(R.drawable.full_beam_symbol_in_green,"Full Beam","Indicates the vehicles full beam lights are on"));
        listContact.add(new RCVItem(R.drawable.self_levelling_headlight_symbol_in_green,"Self levelling Headlights","Indicates the self levelling headlights are on."));
        listContact.add(new RCVItem(R.drawable.automatic_park_brake_symbol_in_green,"Auto Park Brake","Indicates the vehicles automatic park brake is in operation."));
        listContact.add(new RCVItem(R.drawable.car_key_symbol_in_green_1,"Security","Indicates the vehicle key is required or another fault with the vehicles security system"));
        listContact.add(new RCVItem(R.drawable.directional_headlight_symbol_in_green,"Directional Headlights","Indicates the vehicles automatic directional headlights are in operation"));
        listContact.add(new RCVItem(R.drawable.fog_light_symbol_in_green,"Fog Light","Indicates the fog lights are on"));
        listContact.add(new RCVItem(R.drawable.parking_sensor_symbol_in_green,"Parking Sensor","Indicates the parking sensor (front or rear) is in operation"));
        listContact.add(new RCVItem(R.drawable.eco_mode_symbol_in_green,"Eco Mode","Indicates the vehicle is in ECO mode"));
        listContact.add(new RCVItem(R.drawable.shift_light_symbol_in_green,"Shift light","Indicates the recommended gear shift to optimise fuel economy"));
    }
}
