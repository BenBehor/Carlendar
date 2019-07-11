package com.mac.ben.carlendar1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
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
        mContext = context;
        mData = listContact;

             switch (color){
            case 1: mColor = R.color.colorRed; break;
            case 2: mColor = R.color.colorYellow; break;
            case 3: mColor = R.color.colorGreen; break;
                default: mColor = R.color.colorGray; break;
        }

    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_rcv, viewGroup,false);
        v.setBackgroundResource(mColor);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.imageIv.setImageResource(mData.get(i).getImage());
        myViewHolder.titleTv.setText(mData.get(i).getTitle());
        myViewHolder.subtitleTv.setText(mData.get(i).getSubtitle());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(mContext,R.anim.blink_anim);
                view.startAnimation(anim);

                String extra = mData.get(i).getExtra();
                if(extra.contains("http")) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(extra));
                    mContext.startActivity(browserIntent);
                }else{
                    new AlertDialog.Builder(mContext)
                            .setTitle(mData.get(i).getTitle())
                            .setMessage(mData.get(i).getExtra() + "some info")
                            .setIcon(mData.get(i).getImage())
                            .show();

                }

            }
        });


        //Create a code that opens a small box with details about the light issue OR a weblink to amazing for store
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