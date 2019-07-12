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
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listContact, 2);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();
        listContact.add(new RCVItem(R.drawable.low_screen_wash_fluid_symbol_in_orange, "Washer Fluid", "Indicates that the vehicle is low on screen wash fluid.", "Top up screen wash as soon as possible to maintain ability to keep windscreen clear."));
        listContact.add(new RCVItem(R.drawable.engine_check_symbol_in_orange, "Engine Check", "Indicates that the main beam / full beam headlights are on", "Use main / full beam when appropriate taking precautions not to dazzle on coming drivers."));
        listContact.add(new RCVItem(R.drawable.engine_check_symbol_in_orange_1, "Engine Check", "Indicates fault with engine.", "Stop the vehicle when safe to do so and seek assistance / diagnosis."));
        listContact.add(new RCVItem(R.drawable.electric_charging_symbol_in_orange, "Electric Charging", "Indicates that the vehicle is connected to electrical charging station", "Disconnect from the charging station when appropriate."));
        listContact.add(new RCVItem(R.drawable.charging_symbol_in_orange, "Charging", "Indicates that the vehicle is connected to electrical charging station", "Disconnect from charging station when required."));
        listContact.add(new RCVItem(R.drawable.warning_symbol_in_orange, "Warning", "Indicates a warning", "Navigate the cars on board computer / information system to identify the fault and address accordingly."));
        listContact.add(new RCVItem(R.drawable.pcs_symbol_in_orange, "PCS", "Indicates a fault with the vehicle PCS system.", "Stop the car when safe to do and seek breakdown assistance / diagnosis."));
        listContact.add(new RCVItem(R.drawable.tranmission_warning_symbol_in_orange, "Transmission", "Indicates a fault with the transmission / gearbox.", "Stop the vehicle when safe to do so and seek assistance / diagnosis."));
        listContact.add(new RCVItem(R.drawable.service_indicator_symbol_in_orange, "Service", "Indicates that the vehicle is due for a service.", "Contact service centre to book scheduled maintenance."));
        listContact.add(new RCVItem(R.drawable.jack__ramp_symbol_in_orange, "Jack / Ramp", "Indicates that the vehicle is on a ramp / jack system", "No action required."));
        listContact.add(new RCVItem(R.drawable.low_engine_oil_symbol_in_orange, "Low Engine Oil", "Indicates low engine oil.", "Check engine oil level and top up with correct specification oil as required. Running the engine with low engine oil can cause significant damage to the engine."));
        listContact.add(new RCVItem(R.drawable.at_oil_temp_symbol_in_orange, "A/T Oil Temp", "Indicates that the automatic transmission oil temperature is high.", "Seek assistance / diagnosis asap as could result in significant damage to the automatic transmission."));
        listContact.add(new RCVItem(R.drawable.information_symbol_in_orange, "Indicates an issue that requires attention.", "Navigate the vehicles on board computer / information to identify the issue and address accordingly.", "Navigate the vehicles on board computer / information to identify the issue and address accordingly."));
        listContact.add(new RCVItem(R.drawable.oil_level_symbol_in_orange, "Oil Level", "Indicates the oil level is outside of the recommended parameters.", "Check engine oil level manually, if low, top up with correct specification oil to correct level, if high seem assistance to have drained."));
        listContact.add(new RCVItem(R.drawable.warning_symbol_in_orange_1, "Warning", "Indicates a warning", "Navigate the cars on board computer / information system to identify the fault and address accordingly."));
        listContact.add(new RCVItem(R.drawable.side_air_bag_symbol_in_orange, "Side air bag", "Indicates a fault with the side air bag.", "Seek assistance / diagnosis to ensure airbag system is fully functional as it provides a vital part of the cars safety features."));
        listContact.add(new RCVItem(R.drawable.glow_plug_symbol_in_orange, "Glow Plug", "Indicates the vehicles glow plugs are in operation (diesel vehicles only)", "Diesel engines require the fuel to be pre-warmed before starting, if the light stays on there is a fault with the glow plugs and may need replacing."));
        listContact.add(new RCVItem(R.drawable.brake_warning_orange, "Brake Warning", "Indicates a fault with the vehicles braking system.", "Stop the vehicle when safe to do so and seek assistance / diagnosis to ensure the braking system is fully operational."));
        listContact.add(new RCVItem(R.drawable.esp_warning_light_in_orange, "ESP Warning", "Indicates a fault with the vehicles ESP (electronic stability program", "Stop the vehicle when safe to do so and seek assistance / diagnosis. The ESP is an important part of the cars safety systems. "));
        listContact.add(new RCVItem(R.drawable.abs_warning_light_in_orange, "ABS Warning", "Indicates a fault with the vehicles ABS (anti-lock braking system)", "Stop the vehicle when safe to do so and seek assistance / diagnosis, the ABS system is a vital safety feature on the vehicle."));
        listContact.add(new RCVItem(R.drawable.rbs_warning_light_in_orange, "RBS Warning", "Indicates a fault with the RBS (Recuperative Brake System), applicable to hybrid vehicles only", "Schedule maintenance to have the RBS system inspected / repaired as necessary."));
        listContact.add(new RCVItem(R.drawable.brake_pad_warning_symbol_in_orange, "Brake Pad", "Indicates a fault with the brake pads, most likely that they are wearing low and require replacement", "Book maintenance for the vehicle to have brake pads checked / replaced if necessary."));
        listContact.add(new RCVItem(R.drawable.regenerative_brake_force_symbol_in_orange, "Regenerative Brake Force", "Indicates when the regenerative brake force has declined.", "Schedule maintenance to have the system checked, reduced battery charge (hybrid only) likely."));
        listContact.add(new RCVItem(R.drawable.press_brake_pedal_symbol_in_orange, "Press Brake Pedal", "Indicates the brake pedal must be pushed to start the engine.", "Push the brake pedal to start the engine (only applicable to automatic transmission vehicles)."));
        listContact.add(new RCVItem(R.drawable.brake_warning_symbol_in_orange_1, "Brake Warning", "Indicates a fault with the vehicles braking system.", "Stop the vehicle when safe to do so and seek assistance / diagnosis to ensure the vehicles braking system is operating correctly."));
        listContact.add(new RCVItem(R.drawable.water_in_fuel_symbol_in_orange, "Water in Fuel", "Indicates water in the fuel.", "Diesel vehicles are equipped with separators that remove water from the fuel, this symbol could indicate a fault with the separator or indicate contaminated fuel."));
        listContact.add(new RCVItem(R.drawable.tpms_warning_symbol_in_orange, "TPMS", "Indicates a change in tyre pressure has been detected by the TPMS (tyre pressure monitoring system)", "Stop the vehicle when safe to do so and check tyre pressures or for signs of puncture / foreign object in tyre. Fit spare / deploy tyre repair system if confident to do so or seek assistance."));
        listContact.add(new RCVItem(R.drawable.tpms_warning_symbol_in_orange_1, "TPMS", "Indicates a change in tyre pressure has been detected by the TPMS (tyre pressure monitoring system)", "Stop the vehicle when safe to do so and check tyre pressures or for signs of puncture / foreign object in tyre. Fit spare / deploy tyre repair system if confident to do so or seek assistance."));
        listContact.add(new RCVItem(R.drawable.dpf_warning_symbol_in_orange, "DPF", "Indicates a fault with the DPF (diesel particulate filter)", "Book maintenance for the vehicle to have the DPF inspected / replaced where necessary. The DPF prevents harmful emissions escaping into the atmosphere."));
        listContact.add(new RCVItem(R.drawable.tcs_symbol_in_orange, "TCS", "Indicates the vehicles TCS (traction control system) has been activated.", "Adjust your driving to suit the conditions, if light remains on, seek diagnosis and could indicate a fault with the system."));
        listContact.add(new RCVItem(R.drawable.tcs_symbol_in_orange_1, "TCS", "Indicates the vehicles TCS (traction control system) has been activated.", "Adjust driving style to suit conditions."));
        listContact.add(new RCVItem(R.drawable.tcs_off_symbol_in_orange, "TCS Off", "Indicates the vehicles TCS (traction control system) has be deactivated.", "Reactivate TCS when appropriate, the traction control system provides an essential part of the vehicles safety features."));
        listContact.add(new RCVItem(R.drawable.tcs_symbol_in_orange_2, "TCS", "Indicates the vehicles TCS (traction control system) has been activated.", "Adjust driving style to suit conditions."));
        listContact.add(new RCVItem(R.drawable.car_key_symbol_in_orange, "Key", "Indicates the vehicle key is required or another fault with the vehicles security system", "Insert the car key into ignition to start the vehicle."));
        listContact.add(new RCVItem(R.drawable.towing_symbol_in_orange, "Trailer", "Indicates the vehicle is towing", "Take extra care when towing."));
        listContact.add(new RCVItem(R.drawable.fourxtwo_symbol_in_orange, "4x2", "Indicates that a 4WD capable vehicle is in 4x2 mode (2WD)", "No action required"));
        listContact.add(new RCVItem(R.drawable.four_wd_symbol_in_orange, "4WD", "Indicates the vehicle is in 4WD mode", "No action required."));
        listContact.add(new RCVItem(R.drawable.fourxfour_auto_symbol_in_orange, "4x4 Auto", "Indicates the vehicle is in automatic 4WD mode", "No actions required."));
        listContact.add(new RCVItem(R.drawable.fourxfour_high_symbol_in_orange, "4x4 High", "Indicates the vehicle is in 4x4 High gear mode", "No actions required."));
        listContact.add(new RCVItem(R.drawable.fourxfour_low_symbol_in_orange, "4x4 Low", "Indicates the vehicle is in 4x4 Low gear mode", "No action required."));
        listContact.add(new RCVItem(R.drawable.centre_differential_lock_symbol_in_orange, "Centre Differential Lock", "Indicates center differential lock (or 4Hi/Lo) indicator", "No action required."));
        listContact.add(new RCVItem(R.drawable.rear_differential_lock_symbol_in_orange, "Rear Differential Lock", "Indicates rear differential lock indicator", "No action required"));
        listContact.add(new RCVItem(R.drawable.differential_lock_symbol_in_orange, "Differential Lock", "Indicates differential lock indicator", "No action required."));
        listContact.add(new RCVItem(R.drawable.power_limitation_indicator_symbol_in_orange, "Power Limitation Indicator", "Indicates that eclectic power is limited, only found on electric / hybrid vehicles", "If warning light shows unexpectedly, schedule maintenance to have the electric / hybrid system inspected."));
        listContact.add(new RCVItem(R.drawable.parking_sensor_symbol_in_orange, "Parking Sensor", "Indicates the parking sensor (front or rear) is in operation", "Take note of parking sensor frequency to avoid collision when parking / reversing. A solid tone means the proximity to an external object is critical."));
        listContact.add(new RCVItem(R.drawable.lane_assist_symbol_in_orange, "Lane Assist", "Indicates the lane assist function is in operation", "Maintain concentration when driving, if feeling tired then stop and take a break."));
        listContact.add(new RCVItem(R.drawable.startstop_symbol_in_orange, "Start / Stop", "Indicates the vehicles automatic start / stop system is in operation", "No action required, continue to drive as normal and the engine will start and stop as required to reduce emissions."));
        listContact.add(new RCVItem(R.drawable.low_fuel_warning_light_in_orange, "Low Fuel", "Indicates low fuel.", "Visit your nearest petrol station and re-fuel. The vehicle range on low fuel ranges from 10-50 miles typically."));
        listContact.add(new RCVItem(R.drawable.fog_light_symbol_in_orange, "Fog Light", "Indicates the vehicle fog lights are on", "Ensure fog lights are switched off when conditions improve as foglights can dazzle other road users."));
        listContact.add(new RCVItem(R.drawable.traction_control_fault_light, "Traction Control Fault Light", "Indicates a fault with the traction control system", "Schedule maintenance to diagnose / recitfy fault, drive with caution in the interim."));
        listContact.add(new RCVItem(R.drawable.cruise_control, "Cruise Control", "Indicates the cruise control is in operation.", "No action required, cruise control will automatically deactivate when the throttle / brake / clutch is engaged."));
    }

}
