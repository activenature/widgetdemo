package com.example.chdating;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioGroupActivity extends Activity {
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radio1,radio2,radio3,radio4;

    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.radiogroup);
        textView=findViewById(R.id.radiohello);
        radioGroup=findViewById(R.id.radopgroup1);
        radio1=findViewById(R.id.radiobutton1);
        radio2=findViewById(R.id.radiobutton2);
        radio3=findViewById(R.id.radiobutton3);
        radio4=findViewById(R.id.radiobutton4);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String text="我最喜欢的活动是";
                if(i==radio1.getId()){
                    text+=radio1.getText().toString();
                    textView.setText(text);
                }
                else if(i==radio2.getId()){
                    text+=radio2.getText().toString();
                    textView.setText(text);
                }
                else if(i==radio3.getId()){
                    text+=radio3.getText().toString();
                    textView.setText(text);
                }
                else if(i==radio4.getId()){
                    text+=radio4.getText().toString();
                    textView.setText(text);
                }

            }
        });

    }

}
