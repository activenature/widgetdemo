package com.example.chdating;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextViewActivity extends Activity {
    private AutoCompleteTextView textView;
    private static final String[] autotext=new String[]{"张三","张无忌","张三丰"};
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompletetextview);
        textView=findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,autotext);
        textView.setAdapter(adapter);
    }

}
