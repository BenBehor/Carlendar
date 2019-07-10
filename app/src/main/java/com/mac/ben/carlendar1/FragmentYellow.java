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

public class FragmentYellow extends Fragment {

    private List<RCVItem> listContact = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_dashboard, container, false);
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_dashboard);
        myRecyclerView.setHasFixedSize(true); //to improve performance.
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listContact, 2);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        listContact.add(new RCVItem(R.drawable.low_screen_wash_fluid_symbol_in_orange,"Washer Fluid","Indicates that the vehicle is low on screen wash fluid."));
        listContact.add(new RCVItem(R.drawable.engine_check_symbol_in_orange,"Engine Check","Indicates that the main beam / full beam headlights are on"));
        listContact.add(new RCVItem(R.drawable.engine_check_symbol_in_orange_1,"Engine Check","Indicates fault with engine."));
        listContact.add(new RCVItem(R.drawable.electric_charging_symbol_in_orange,"Electric Charging","Indicates that the vehicle is connected to electrical charging station"));
        listContact.add(new RCVItem(R.drawable.charging_symbol_in_orange,"Charging","Indicates that the vehicle is connected to electrical charging station"));
        listContact.add(new RCVItem(R.drawable.warning_symbol_in_orange,"Warning","Indicates a warning"));
        listContact.add(new RCVItem(R.drawable.pcs_symbol_in_orange,"PCS","Indicates a fault with the vehicle PCS system."));
        listContact.add(new RCVItem(R.drawable.tranmission_warning_symbol_in_orange,"Transmission","Indicates a fault with the transmission / gearbox."));
        listContact.add(new RCVItem(R.drawable.service_indicator_symbol_in_orange,"Service","Indicates that the vehicle is due for a service."));
        listContact.add(new RCVItem(R.drawable.jack__ramp_symbol_in_orange,"Jack / Ramp","Indicaes that the vehicle is on a ramp / jack system"));
        listContact.add(new RCVItem(R.drawable.low_engine_oil_symbol_in_orange,"Low Engine Oil","Indicates low engine oil."));
        listContact.add(new RCVItem(R.drawable.at_oil_temp_symbol_in_orange,"A/T Oil Temp","Indicates that the automatic transmission oil termperature is high."));
        listContact.add(new RCVItem(R.drawable.information_symbol_in_orange,"Indicates an issue that requires attention.","Navigate the vehicles onboard computer / information to identify the issue and address accordingly."));
        listContact.add(new RCVItem(R.drawable.oil_level_symbol_in_orange,"Oil Level","Indicates the oil level is outside of the recommended parameters."));
        listContact.add(new RCVItem(R.drawable.warning_symbol_in_orange_1,"Warning","Indicates a warning"));
        listContact.add(new RCVItem(R.drawable.side_air_bag_symbol_in_orange,"Side air bag","Indicates a fault with the side air bag."));
        listContact.add(new RCVItem(R.drawable.warning_symbol_in_orange,"To be continued:","more data will be updated soon")); // so far 2 lines.
    }
}
