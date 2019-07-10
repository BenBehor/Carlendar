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

public class FragmentStore extends Fragment {

    private List<RCVItem> listContact = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_store, container, false);
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_store);
        myRecyclerView.setHasFixedSize(true); //to improve performance.
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listContact, 0);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        listContact.add(new RCVItem(R.drawable.nonda_zus,"Nonda ZUS Smart Car Charger with Car Finder","Locate Your Car In The Busiest Of Parking Lots"));
        listContact.add(new RCVItem(R.drawable.maxboost_car_nount,"Maxboost Car Mount","Mount Your Phone Without Any Installation"));
        listContact.add(new RCVItem(R.drawable.topfit,"Topfit Anti-Slip Car Dash Grip Pad","This silicone grip pad requires zero installation — just place it on your dashboard, where it can grip and hold onto phones, sunglasses, keys, and cables."));
        listContact.add(new RCVItem(R.drawable.key_finder,"Key Finder","Never Lose Your Keys (Or Phone) Again"));
        listContact.add(new RCVItem(R.drawable.garbage_can,"Drive Car Garbage Can","Have A Place To Consolidate Trash On The Go"));
        listContact.add(new RCVItem(R.drawable.car_vacuum,"Car Vacuum Cleaner","Always Have A Clean-Looking & Fresh-Smelling Car"));
        listContact.add(new RCVItem(R.drawable.storage_net,"Three Pocket Mesh Storage Net","Keep Groceries & Bags From Spilling Everywhere With This Net"));
        listContact.add(new RCVItem(R.drawable.bluetooth_fm_transmitter,"Bluetooth FM Transmitter","Make Any Car Bluetooth-Friendly"));
        listContact.add(new RCVItem(R.drawable.console_side_pocket,"Console Side Pocket","Keep Change & Sunglasses From Falling Between Seats"));
        listContact.add(new RCVItem(R.drawable.natural_car_air_freshener,"Natural Car Air Freshener","Keep Your Car Smelling Naturally Fresh"));
        listContact.add(new RCVItem(R.drawable.seat_cushion,"Seat Cushion","Improve That Daily Commute Tenfold"));
        listContact.add(new RCVItem(R.drawable.peak_car_battery,"Peak Car Battery Jump","A Must-Have For Any Emergency"));
    }
}
