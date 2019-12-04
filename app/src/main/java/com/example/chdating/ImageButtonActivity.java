package com.example.chdating;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageButtonActivity extends Activity {
    private ImageButton imgbtn;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgbtn);
        imgbtn=findViewById(R.id.imageButton1);
        imgView=findViewById(R.id.imageView1);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutParams params=imgView.getLayoutParams();
                params.height +=3;
                params.width +=3;
                imgView.setLayoutParams(params);
            }
        });
    }
}
