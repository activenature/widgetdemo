package com.example.chdating;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity {
    private List<String> list=new ArrayList<>();
    private TextView textView;
    private Spinner spinnertext;
    private ArrayAdapter<String>  adapter;

    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        list.add("A型");
        list.add("B型");
        list.add("O型");
        list.add("AB型");
        list.add("其他");
        textView=findViewById(R.id.textView1);
        spinnertext=findViewById(R.id.spinner1);
        //adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter=new ArrayAdapter<String>(this,R.layout.my_spinner_item,list);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);
        spinnertext.setAdapter(adapter);
        spinnertext.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2,long arg3){
                textView.setText("你的血型是："+adapter.getItem(arg2));
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0){
                textView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);
            }
        });

        spinnertext.setOnTouchListener(new Spinner.OnTouchListener(){
          @Override
          public boolean onTouch(View view,MotionEvent event){
              view.setVisibility(View.INVISIBLE);
              Log.i("spinner","Spinner Touch Event happened!");
              return false;
          }
        });

        spinnertext.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus){
                v.setVisibility(View.VISIBLE);
                Log.i("spinner","Spinner FocusChange Event happened!");
            }
        });

    }

}
