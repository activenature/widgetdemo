package com.example.chdating;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        TabHost tabs=findViewById(R.id.tabhost);
        tabs.setup();


        TabHost.TabSpec spec1=tabs.newTabSpec("Tag1");
        spec1.setContent(R.id.imageView1);
        spec1.setIndicator("Toronto");
        tabs.addTab(spec1);

        TabHost.TabSpec spec2=tabs.newTabSpec("Tag2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Tab2");
        tabs.addTab(spec2);

        TabHost.TabSpec spec3=tabs.newTabSpec("Tag3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Tab3");
        tabs.addTab(spec3);

        tabs.setCurrentTab(1);



    }

}
