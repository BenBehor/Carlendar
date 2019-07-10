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

public class FragmentRed extends Fragment {

    private List<RCVItem> listContact = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_dashboard, container, false);
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_dashboard);
        myRecyclerView.setHasFixedSize(true); //to improve performance.
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listContact, 1);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        listContact.add(new RCVItem(R.drawable.back_boot_open,"Bonnet Open","Indicates that the vehicles bonnet is open or not secured properly and could open whilst driving."));
        listContact.add(new RCVItem(R.drawable.doors_open,"Door(s) Open","Indicates that one or more of the vehicle doors is open or not closed properly."));
        listContact.add(new RCVItem(R.drawable.power_steering,"Power Steering","Indicates a fault with the power steering system."));
        listContact.add(new RCVItem(R.drawable.seatbelt_symbol,"Seat Belt","Indicates that a seat belt has not been secured for a passenger in the vehicle."));
        listContact.add(new RCVItem(R.drawable.oil_pressure,"Oil Pressure","Indicates that the oil pressure is low."));
        listContact.add(new RCVItem(R.drawable.battery,"Battery","Indicates a fault with the battery if light does not go out after ignition, likely low charge."));
        listContact.add(new RCVItem(R.drawable.hand_brake,"Hand Brake / Park Brake","Indicates the hand brake / park brake is on."));
        listContact.add(new RCVItem(R.drawable.air_bag,"Air Bag","Indicates a fault with the airbag system."));
        listContact.add(new RCVItem(R.drawable.low_engine_oil,"Low Engine Oil","Indicates the engine oil level is low."));
        listContact.add(new RCVItem(R.drawable.battery_warning,"Battery Warning","Indicates a fault with the main battery if light does not go out after ignition, likely low charge."));
        listContact.add(new RCVItem(R.drawable.brake_warning,"Brake Warning","indicates a fault with the braking system"));
        listContact.add(new RCVItem(R.drawable.car_lock,"Car Lock","Indicates that the vehicle is locked"));
        listContact.add(new RCVItem(R.drawable.at_oil_temp,"A/T Oil Temp","Indicates that the automatic transmission oil temperature is high."));
        listContact.add(new RCVItem(R.drawable.hazard_warning_light,"Hazard Lights","Indicates that the vehicles hazard warning lights are on."));
        listContact.add(new RCVItem(R.drawable.brake,"Brake Warning","Indicates a fault with the braking system."));
        listContact.add(new RCVItem(R.drawable.airbag_off,"Airbag Off","Indicates that an airbag has been switched off manually."));
        listContact.add(new RCVItem(R.drawable.srs,"SRS","Indicates a fault with the SRS (supplementary restraint system) more commonly known as air bag system"));
        listContact.add(new RCVItem(R.drawable.lock,"Locked","Indicates that the vehicle is locked"));
        listContact.add(new RCVItem(R.drawable.at_p,"A/T P","Indicates the 4WD system is in neutral. Can also indicate a fault with the park gear in automatic transmission."));
        listContact.add(new RCVItem(R.drawable.brake_warning2,"Brake Warning","Indicates a fault with the vehicle braking system."));
        listContact.add(new RCVItem(R.drawable.brake_pad,"Brake Pad","Indicates a fault with the brake pads, most likely that they are wearing low and require replacement."));
        listContact.add(new RCVItem(R.drawable.brake_fluid,"Brake Fluid","Indicates the brake fluid level is low."));
        listContact.add(new RCVItem(R.drawable.transmission,"Transmission","Indicates a fault with the transmission / gearbox."));
        listContact.add(new RCVItem(R.drawable.transmission_temperature,"Transmission Temperature","Indicates that the transmission / gearbox temperature is high."));
        listContact.add(new RCVItem(R.drawable.car_key,"Secuirty","Indicates the vehicle key is required or another fault with the vehicles security system"));
        listContact.add(new RCVItem(R.drawable.engine_temperature,"Engine Temperature Warning","Indicates that the engine temperature is high."));
    }
}
