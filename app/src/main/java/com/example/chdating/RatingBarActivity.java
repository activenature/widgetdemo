package com.example.chdating;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class RatingBarActivity extends Activity {
    private RatingBar chooseRatingBar;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbar);
        textView=findViewById(R.id.textView1);
        chooseRatingBar=findViewById(R.id.ratingBar1);
        chooseRatingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                chooseRatingBar.setRating(rating);
                textView.setText("您选择了"+rating+"个星星");
            }
        });
    }
}
