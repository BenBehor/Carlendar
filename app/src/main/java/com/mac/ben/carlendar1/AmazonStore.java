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

public class AmazonStore extends Fragment {

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
        listContact.add(new RCVItem(R.drawable.car_charger,"Smart Car Charger with Car Finder","Locate Your Car In The Busiest Of Parking Lots","https://www.amazon.com/nonda-Charger-Finder-Reversible-iPhone/dp/B01HMF7M38/ref=as_li_ss_tl?creativeASIN=B01HMF7M38&imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=2&ie=UTF8&qid=1475504454&sr=8-1&keywords=find+car+parking+lot&linkCode=sl1&tag=bustle1558-20&linkId=c43a911adad212b9398e66b34bfe37e9"));
        listContact.add(new RCVItem(R.drawable.car_mount,"Maxboost Car Mount","Mount Your Phone Without Any Installation","https://www.amazon.com/gp/product/B01M0GTZDN?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=4&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B01M0GTZDN"));
        listContact.add(new RCVItem(R.drawable.anti_slip_pad,"Anti-Slip Car Dash Grip Pad","Grip anything with the silicone grip pad.","https://www.amazon.com/gp/product/B01HXQS230?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=6&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B01HXQS230"));
        listContact.add(new RCVItem(R.drawable.key_finder,"Key Finder","Never Lose Your Keys (Or Phone) Again","https://www.amazon.com/gp/product/B01CMJ6GPY/ref=as_li_ss_tl?creativeASIN=B01CMJ6GPY&imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=8&ie=UTF8&refRID=1G78FW8MNE5H410E1735&th=1&linkCode=sl1&tag=bustle1558-20&linkId=fdf7504a0e08637782d5fefdd117bb40"));
        listContact.add(new RCVItem(R.drawable.garbage_can,"Drive Car Garbage Can","Have A Place To Consolidate Trash On The Go","https://www.amazon.com/gp/product/B01078GH6A?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=10&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B01078GH6A"));
        listContact.add(new RCVItem(R.drawable.car_vacuum,"Car Vacuum Cleaner","Always Have A Clean-Looking & Fresh-Smelling Car","https://www.amazon.com/LOLLDEAL-Portable-hand-held-Automotive-Carrying/dp/B01GRRCU02/ref=as_li_ss_tl?creativeASIN=B01GRRCU02&imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=12&_encoding=UTF8&pd_rd_i=B01GRRCU02&pd_rd_r=2RJEH19CQZPGB0PFBW4H&pd_rd_w=0aAkZ&pd_rd_wg=GOthJ&psc=1&refRID=2RJEH19CQZPGB0PFBW4H&linkCode=w61&tag=bustle1558-20&linkId=22db5cceba20d94daa541b643390c036"));
        listContact.add(new RCVItem(R.drawable.storage_net,"Three Pocket Mesh Storage Net","Keep Groceries & Bags From Spilling Everywhere With This Net","https://www.amazon.com/gp/product/B00IIVUXLO?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=15&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B00IIVUXLO"));
        listContact.add(new RCVItem(R.drawable.bluetooth_fm_transmitter,"Bluetooth FM Transmitter","Make Any Car Bluetooth-Friendly","https://www.amazon.com/Nulaxy-Bluetooth-Transmitter-Receiver-Handsfree/dp/B01MFBIF99/ref=as_li_ss_tl?creativeASIN=B01MFBIF99&imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=17&s=electronics&ie=UTF8&qid=1524690523&sr=1-4&keywords=bluetooth+adapter&th=1&linkCode=w61&tag=bustle1558-20&linkId=4f09041b7a33dc6ed4bfc1f2fdcfbd0e"));
        listContact.add(new RCVItem(R.drawable.console_side_pocket,"Console Side Pocket","Keep Change & Sunglasses From Falling Between Seats","https://www.amazon.com/gp/product/B01C33AQNC?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=20&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B01C33AQNC"));
        listContact.add(new RCVItem(R.drawable.natural_car_air_freshener,"Natural Car Air Freshener","Keep Your Car Smelling Naturally Fresh","https://www.amazon.com/gp/product/B01D3TQHYC?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=22&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B01D3TQHYC"));
        listContact.add(new RCVItem(R.drawable.seat_cushion,"Seat Cushion","Improve That Daily Commute Tenfold","https://www.amazon.com/gp/product/B01A5EQJVO?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=24&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B01A5EQJVO"));
        listContact.add(new RCVItem(R.drawable.peak_car_battery,"Peak Car Battery Jump","A Must-Have For Any Emergency","https://www.amazon.com/gp/product/B000BO4WU4?imprToken=VRAkYnB-jDiXYZZMooOzGg&slotNum=26&ie=UTF8&tag=bustle1558-20&camp=1789&linkCode=xm2&creativeASIN=B000BO4WU4"));
    }
}
