package com.example.chdating;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

public class BitMapActivity extends Activity {

    ImageView myImageView;
    Bitmap myBmp,newBmp;
    int bmpWidth,bmpHeight;
    SeekBar seekbarRotate;
    float rotAngle;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap);
        myImageView=findViewById(R.id.imageview);
        myBmp=BitmapFactory.decodeResource(getResources(),R.drawable.spring);
        bmpWidth=myBmp.getWidth();
        bmpHeight=myBmp.getHeight();
        Matrix matrix=new Matrix();
        matrix.postScale(1.5F,1.5F);
        matrix.postRotate(45F);
        newBmp=Bitmap.createBitmap(myBmp,0,0,bmpWidth,bmpHeight,matrix,true);
        myImageView.setImageBitmap(newBmp);
        seekbarRotate=findViewById(R.id.seekBar);
        seekbarRotate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Matrix m=new Matrix();
                m.postRotate((float)progress*3.6F);
                Bitmap newBmp1=Bitmap.createBitmap(myBmp,0,0,bmpWidth,bmpHeight,m,true);
                myImageView.setImageBitmap(newBmp1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        refreshLife("onCreate");
    }

    public void refreshLife(String desc){
        Log.d("BitMapActivity",desc);
    }

    @Override
    protected void onStop(){
        refreshLife("onStop");
        super.onStop();
    }

    @Override
    protected void onStart(){
        refreshLife("onStart");
        super.onStart();
    }

    @Override
    protected void onResume(){
        refreshLife("onResume");
        super.onResume();
    }

    @Override
    protected void onPause(){
        refreshLife("onPause");
        super.onPause();
    }

    @Override
    protected void onRestart(){
        refreshLife("onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy(){
        refreshLife("onDestroy");
        super.onDestroy();
    }

}
