package com.mac.ben.carlendar1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Integer mColor;
    private Context mContext;
    private List<RCVItem> mData;

    RecyclerViewAdapter(Context context, List<RCVItem> listContact, Integer color) {
        mColor = color;
        mContext = context;
        mData = listContact;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_rcv, viewGroup,false);
        switch (mColor){
            case 1:
                v.setBackgroundResource(R.color.colorRed);
                break;
            case 2:
                v.setBackgroundResource(R.color.colorYellow);
                break;
            default:
                v.setBackgroundResource(R.color.colorGreen);
                break;
        }
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.imageIv.setImageResource(mData.get(i).getImage());
        myViewHolder.titleTv.setText(mData.get(i).getTitle());
        myViewHolder.subtitleTv.setText(mData.get(i).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageIv;
        private TextView titleTv;
        private TextView subtitleTv;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageIv = itemView.findViewById(R.id.rcv_item_iv);
            titleTv = itemView.findViewById(R.id.rcv_item_title);
            subtitleTv = itemView.findViewById(R.id.rcv_item_subtitle);
        }
    }
}