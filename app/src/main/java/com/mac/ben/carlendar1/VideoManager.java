package com.mac.ben.carlendar1;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.VideoView;

class VideoManager {

    private VideoView mVideoView;
    private Context mContext;
    private ProgressBar mProgressBar;


    VideoManager(Context context, VideoView videoView, ProgressBar progressBar){
       mVideoView = videoView;
       mContext = context;
       mProgressBar = progressBar;
    }

    void playVideo(Integer position){
        if (position != 0) {
            String path = "";
            mProgressBar.setVisibility(View.VISIBLE);
            mVideoView.startAnimation(AnimationUtils.loadAnimation(mContext,R.anim.bounce));
            switch (position) {
                case 1: path = mContext.getString(R.string.vid1);break;
                case 2: path = mContext.getString(R.string.vid2);break;
                case 3: path = mContext.getString(R.string.vid3);break;
                case 4: path = mContext.getString(R.string.vid4);break;
                case 5: path = mContext.getString(R.string.vid5);break;
                case 6: path = mContext.getString(R.string.vid6);break;
                case 7: path = mContext.getString(R.string.vid7);break;
                case 8: path = mContext.getString(R.string.vid8);break;
                case 9: path = mContext.getString(R.string.vid9);break;
                default: break;
            }
            Uri uri = Uri.parse(path);
            mVideoView.setVisibility(View.VISIBLE);
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mProgressBar.setVisibility(View.INVISIBLE);

                     }});
            mVideoView.setVideoURI(uri);
            mVideoView.requestFocus();
            mVideoView.start();
            mVideoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mVideoView.isPlaying()) {
                        mVideoView.pause();
                    } else {
                        mVideoView.start();

                    }
                }
            });

        }
    }

}
