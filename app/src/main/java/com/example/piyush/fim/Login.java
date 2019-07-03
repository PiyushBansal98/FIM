package com.example.piyush.fim;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.VideoView;

public class Login extends AppCompatActivity {
    Toolbar toolbar;
    Button b1,b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar=findViewById(R.id.tool);
        b2=findViewById(R.id.bt2);
        b3=findViewById(R.id.bt3);
//        b4=findViewById(R.id.help);
//
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i67= new Intent(Login.this,web.class);
//                startActivity(i67);
//            }
//        });




        b1=findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,Farmlog.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,ngologin.class);
                startActivity(intent);
            }
        });
        /*Button buttonPlayVideo2 = (Button)findViewById(R.id.button1);

        getWindow().setFormat(PixelFormat.UNKNOWN);

//displays a video file
        VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView1);

        String uriPath2 = "android.resource://com.example.toyo.playvideo/"+R.raw.pop;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();

        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView1);
                // VideoView mVideoView = new VideoView(this);
                String uriPath = "android.resource://com.example.toyo.playvideo/" + R.raw.pop;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.requestFocus();
                mVideoView2.start();
            }
        });*/


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent24 = new Intent(Login.this,sarpanchlogin.class);
                startActivity(intent24);
            }
        });



        final VideoView videoView = new VideoView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 20, 0, 0);
        videoView.setLayoutParams(layoutParams);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.fimvid;
        videoView.setVideoURI(Uri.parse(path));

        LinearLayout linearLayout = findViewById(R.id.rootContainer);
        // Add VideoView to LinearLayout
        if (linearLayout != null) {
            linearLayout.addView(videoView);
        }
        videoView.start();

        //*final Button button = findViewById(R.id.button936);
        if (videoView != null) {
           videoView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   boolean isPlaying = videoView.isPlaying();
                   //button.setText(isPlaying ? R.string.play : R.string.pause);

                   //String msg = getString(isPlaying ? R.string.paused : R.string.playing);
                   //Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();
                   if (isPlaying) {
                       videoView.pause();
                   } else {
                       videoView.start();
                   }
               }
           });
        }




    }
}
