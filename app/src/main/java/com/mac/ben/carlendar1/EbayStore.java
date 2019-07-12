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

public class EbayStore extends Fragment {

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
        listContact.add(new RCVItem(R.drawable.backup_camera_ebay,"Backup Camera","A backup camera gives you an extra set of eyes in hard-to-see spots behind your vehicle. ","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Backup+Camera&_sacat=0"));
        listContact.add(new RCVItem(R.drawable.car_blindspot_mirror_ebay,"Blind-Spot Mirrors","Attach to your regular outside mirrors. They can make driving safer.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Blind+spot+mirror&_sacat=0"));
        listContact.add(new RCVItem(R.drawable.bluetooth_adapter_audio_ebay,"Bluetooth Smart-phone Adapter","These adapters plug into your cigarette lighter and connect to your vehicle’s existing audio system.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Bluetooth++Adapter+audio+car&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=Bluetooth++Adapter+audio"));
        listContact.add(new RCVItem(R.drawable.car_vacuum_ebay,"Cordless Car Vacuum","Make it easy on yourself with a battery-powered vacuum cleaner.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Cordless+Car+Vacuum&_sacat=0"));
        listContact.add(new RCVItem(R.drawable.dash_cam_ebay,"Dash Cam","Having a video and audio recording of an accident will leave no doubt about the facts of the situation.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=dash+cam&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=dashcam"));
        listContact.add(new RCVItem(R.drawable.dash_grip_pads_ebay,"Dash Grip Pads","Anti-slip sticky pads. Just place one on your dashboard or any other surface in your car, and they will keep items.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Dash+Grip+Pads&_sacat=0"));
        listContact.add(new RCVItem(R.drawable.digital_tire_gauge_ebay,"Digital Tire Gauge"," Keep one of these in your glove box, and use it to check your tire pressures every two weeks.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Digital+Tire+Gauge&_sacat=0"));
        listContact.add(new RCVItem(R.drawable.dog_seat_cover_ebay,"Dog Seat Cover"," Backseat dog covers help keep your vehicle fur-free.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Dog+seat+cover&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=Dog+seat+cover"));
        listContact.add(new RCVItem(R.drawable.emergency_kit_ebay,"Roadside Emergency Kit"," Having a roadside emergency kit in your car will keep you safe until help arrives.","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Roadside+Emergency+Kit&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=Roadside+Emergency+Kit"));
        listContact.add(new RCVItem(R.drawable.windshield_cover_ebay,"Windshield Snow Cover","To clean the windshield, just pull the cover off and your windshield is clean,","https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Windshield+snow+cover&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=Windshield+snow+cover"));
    }
}
