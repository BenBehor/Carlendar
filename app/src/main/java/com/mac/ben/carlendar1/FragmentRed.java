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
        listContact.add(new RCVItem(R.drawable.back_boot_open,"Bonnet Open","Indicates that the vehicles bonnet is open or not secured properly and could open whilst driving.","Ensure boot / trunk is securely closed before setting off."));
        listContact.add(new RCVItem(R.drawable.doors_open,"Door(s) Open","Indicates that one or more of the vehicle doors is open or not closed properly.","Ensure all doors are securely closed before setting off."));
        listContact.add(new RCVItem(R.drawable.power_steering,"Power Steering","Indicates a fault with the power steering system.","Stop the vehicle when safe to do so and seek assistance / diagnosis, sudden loss of power steering will make steering the vehicle very difficult and could cause an accident."));
        listContact.add(new RCVItem(R.drawable.seatbelt_symbol,"Seat Belt","Indicates that a seat belt has not been secured for a passenger in the vehicle.","Check all passengers have seat belts secured before setting off."));
        listContact.add(new RCVItem(R.drawable.oil_pressure,"Oil Pressure","Indicates that the oil pressure is low.","Stop the vehicle when safe to do and check oil level or seek assistance / diagnosis. Running the engine with low oil pressure can cause significant damage to the engine."));
        listContact.add(new RCVItem(R.drawable.battery,"Battery","Indicates a fault with the battery if light does not go out after ignition, likely low charge.","Re-charge / replace battery if confirmed that battery is faulty / beyond its design life."));
        listContact.add(new RCVItem(R.drawable.hand_brake,"Hand Brake / Park Brake","Indicates the hand brake / park brake is on.","Release hand / park brake before setting off."));
        listContact.add(new RCVItem(R.drawable.air_bag,"Air Bag","Indicates a fault with the airbag system.","Seek assistance / diagnosis at the earliest opportunity."));
        listContact.add(new RCVItem(R.drawable.low_engine_oil,"Low Engine Oil","Indicates the engine oil level is low.","Stop the vehicle when safe to do so and top up oil to correct level, or seek assistance. Running the engine with low oil can cause significant damage to the engine."));
        listContact.add(new RCVItem(R.drawable.battery_warning,"Battery Warning","Indicates a fault with the main battery if light does not go out after ignition, likely low charge.","Re-charge / replace battery if confirmed that battery is faulty / beyond its design life."));
        listContact.add(new RCVItem(R.drawable.brake_warning,"Brake Warning","indicates a fault with the braking system","Stop the vehicle when safe to do so and seek assistance / diagnosis for immediate repair."));
        listContact.add(new RCVItem(R.drawable.car_lock,"Car Lock","Indicates that the vehicle is locked","Unlock the car if required. If battery has failed in keyfob, use manual key override."));
        listContact.add(new RCVItem(R.drawable.at_oil_temp,"A/T Oil Temp","Indicates that the automatic transmission oil temperature is high.","You should stop the vehicle when safe to do so and seek assistance / diagnosis as could cause significant damage to the gearbox"));
        listContact.add(new RCVItem(R.drawable.hazard_warning_light,"Hazard Lights","Indicates that the vehicles hazard warning lights are on.","Turn off hazard warning lights when no longer required."));
        listContact.add(new RCVItem(R.drawable.brake,"Brake Warning","Indicates a fault with the braking system.","Stop the vehicle when safe to do so and seek assistance / diagnosis for immediate repair."));
        listContact.add(new RCVItem(R.drawable.airbag_off,"Airbag Off","Indicates that an airbag has been switched off manually.","When travelling with baby seats in the front passenger seat of a vehicle, the airbag for the passenger should be disabled, ensure you re-enable it when the child is not travelling in the front seat."));
        listContact.add(new RCVItem(R.drawable.srs,"SRS","Indicates a fault with the SRS (supplementary restraint system) more commonly known as air bag system","Seek immediate assistance / diagnosis. The SRS is an essential part of the cars safety devices in the event of a crash"));
        listContact.add(new RCVItem(R.drawable.lock,"Locked","Indicates that the vehicle is locked","Unlock vehicle when required."));
        listContact.add(new RCVItem(R.drawable.at_p,"A/T P","Indicates the 4WD system is in neutral. Can also indicate a fault with the park gear in automatic transmission.","Seek assistance / diagnosis, ensure hand / parking brake is applied securely in case of fault with park gear."));
        listContact.add(new RCVItem(R.drawable.brake_warning2,"Brake Warning","Indicates a fault with the vehicle braking system.","Stop the vehicle when safe to do so and seek assistance / diagnosis for immediate repair."));
        listContact.add(new RCVItem(R.drawable.brake_pad,"Brake Pad","Indicates a fault with the brake pads, most likely that they are wearing low and require replacement.","Check brake pad wear and have replaced at earliest opportunity."));
        listContact.add(new RCVItem(R.drawable.brake_fluid,"Brake Fluid","Indicates the brake fluid level is low.","Stop the vehicle when safe to do and seek assistance / diagnosis. If possible, top up brake fluid using correct specification fluid to required level."));
        listContact.add(new RCVItem(R.drawable.transmission,"Transmission","Indicates a fault with the transmission / gearbox.","Stop the vehicle when safe to do so and seek assistance / diagnosis."));
        listContact.add(new RCVItem(R.drawable.transmission_temperature,"Transmission Temperature","Indicates that the transmission / gearbox temperature is high.","Stop the vehicle when safe to do so and seek assistance / diagnosis."));
        listContact.add(new RCVItem(R.drawable.car_key,"Secuirty","Indicates the vehicle key is required or another fault with the vehicles security system","Insert key into ignition to start vehicle."));
        listContact.add(new RCVItem(R.drawable.engine_temperature,"Engine Temperature Warning","Indicates that the engine temperature is high.","Stop the vehicle when safe to do so and seek assistance / diagnosis."));
    }
}
