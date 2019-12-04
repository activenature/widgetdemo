package com.example.chdating;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends Activity {
    private  TextView textView;
    private SeekBar seekBar;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);
        textView=findViewById(R.id.textView1);
        seekBar=findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("当前进度为： "+progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("SeekBarActivity","开始拖动");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("SeekBarActivity","拖动停止");

            }
        });
    }

}
