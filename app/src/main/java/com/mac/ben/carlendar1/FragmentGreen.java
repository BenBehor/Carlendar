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
        View v = inflater.inflate(R.layout.frag_dashboard, container, false);
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_dashboard);
        myRecyclerView.setHasFixedSize(true); //to improve performance.
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listContact, 3);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        listContact.add(new RCVItem(R.drawable.engine_start_stop_symbol_in_green,"Engine Stop","Indicates the engine start / stop function is in operation.","Continue as normal, the engine will restart automatically when required."));
        listContact.add(new RCVItem(R.drawable.interior_light_symbol_in_green,"Interior Light","Indicates that the vehicles interior lights are on.","Ensure interior lights are switched off when not required to avoid a flat battery"));
        listContact.add(new RCVItem(R.drawable.car_charging_symbol_in_green,"Charging","Indicates that the vehicle is connected to electrical charging station","Disconnect electric charging when required."));
        listContact.add(new RCVItem(R.drawable.interior_light_warning_in_green,"Interior Light","Indicates that an interior light is on.","Ensure interior lights are switched off when not required to avoid a flat battery"));
        listContact.add(new RCVItem(R.drawable.car_key_symbol_in_green,"Car Key","Indicates the vehicle key is in the ignition","Remove the key from ignition when leaving / locking the car."));
        listContact.add(new RCVItem(R.drawable.ev_mode_symbol_in_green,"EV","Indicates the vehicle is is EV (electric vehicle) mode.","No action required."));
        listContact.add(new RCVItem(R.drawable.side_lights_symbol_in_green,"Side Lights","Indicates that the sidelights are on.","Use the appropriate headlight setting for the conditions."));
        listContact.add(new RCVItem(R.drawable.full_beam_symbol_in_green,"Full Beam","Indicates the vehicles full beam lights are on","Only use full / main beam lights when required taking care not to dazzle oncoming traffic."));
        listContact.add(new RCVItem(R.drawable.self_levelling_headlight_symbol_in_green,"Self levelling Headlights","Indicates the self levelling headlights are on.","No action required."));
        listContact.add(new RCVItem(R.drawable.automatic_park_brake_symbol_in_green,"Auto Park Brake","Indicates the vehicles automatic park brake is in operation.","Continue to drive as normal and the brake will automatically release when required."));
        listContact.add(new RCVItem(R.drawable.car_key_symbol_in_green_1,"Security","Indicates the vehicle key is required or another fault with the vehicles security system","Insett key into ignition to start vehicle."));
        listContact.add(new RCVItem(R.drawable.directional_headlight_symbol_in_green,"Directional Headlights","Indicates the vehicles automatic directional headlights are in operation","No action required."));
        listContact.add(new RCVItem(R.drawable.fog_light_symbol_in_green,"Fog Light","Indicates the fog lights are on","Ensure fog lights are switched off when conditions improve as fog lights can dazzle other road users."));
        listContact.add(new RCVItem(R.drawable.parking_sensor_symbol_in_green,"Parking Sensor","Indicates the parking sensor (front or rear) is in operation","Take note of parking sensor frequency to avoid collision when parking / reversing. A solid tone means the proximity to an external object is critical."));
        listContact.add(new RCVItem(R.drawable.eco_mode_symbol_in_green,"Eco Mode","Indicates the vehicle is in ECO mode","No action required."));
        listContact.add(new RCVItem(R.drawable.shift_light_symbol_in_green,"Shift light","Indicates the recommended gear shift to optimise fuel economy","Shift gear either up or down as directed where appropriate / conditions permit."));
    }
}
