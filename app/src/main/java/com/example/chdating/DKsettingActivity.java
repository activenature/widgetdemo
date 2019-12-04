package com.example.chdating;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


public class DKsettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, TextWatcher {

    private Button btn_save;
    private EditText nickname,cellnumber,email;
    private CheckBox actinfo1,actinfo2,actinfo3,actinfo4,actinfo5,actinfo6,actinfo7,actinfo8,actinfo9,actinfo10,actinfo11,actinfo12,actinfo13;
    private CheckBox lifestatus1,lifestatus2,lifestatus3,lifestatus4,lifestatus5,lifestatus6,lifestatus7,lifestatus8,lifestatus9,lifestatus10,lifestatus11,lifestatus12;
    private String nkname,clnumber,myemail;
    private TextView tv_setting;
    private String[] mactinfo={"旅游","户外","美食","音乐","体育","艺术","汽车","游戏","棋类","牌类","舞蹈","交友","综合"};
    private String[] mlifestatus={"单身","热恋中","失恋中","同居","已婚","独居","自由奔放","保密","难以言说","痛苦","无聊寂寞","非常充实"};
    private SharedPreferences sps;
    private SharedPreferences.Editor editor;
    private Toolbar mToolBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dksetting);

        mToolBar = findViewById(R.id.toolbar1);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        sps=getSharedPreferences("dksettingshare", Context.MODE_PRIVATE);
        editor=sps.edit();

        btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        tv_setting=findViewById(R.id.tv_setting);

        nickname=findViewById(R.id.nickname);
        nickname.addTextChangedListener(this);
        cellnumber=findViewById(R.id.cellnumber);
        cellnumber.addTextChangedListener(this);
        email=findViewById(R.id.email);
        email.addTextChangedListener(this);

        actinfo1=findViewById(R.id.actinfo1);
        actinfo2=findViewById(R.id.actinfo2);
        actinfo3=findViewById(R.id.actinfo3);
        actinfo4=findViewById(R.id.actinfo4);
        actinfo5=findViewById(R.id.actinfo5);
        actinfo6=findViewById(R.id.actinfo6);
        actinfo7=findViewById(R.id.actinfo7);
        actinfo8=findViewById(R.id.actinfo8);
        actinfo9=findViewById(R.id.actinfo9);
        actinfo10=findViewById(R.id.actinfo10);
        actinfo11=findViewById(R.id.actinfo11);
        actinfo12=findViewById(R.id.actinfo12);
        actinfo13=findViewById(R.id.actinfo13);

        actinfo1.setOnCheckedChangeListener(this);
        actinfo2.setOnCheckedChangeListener(this);
        actinfo3.setOnCheckedChangeListener(this);
        actinfo4.setOnCheckedChangeListener(this);
        actinfo5.setOnCheckedChangeListener(this);
        actinfo6.setOnCheckedChangeListener(this);
        actinfo7.setOnCheckedChangeListener(this);
        actinfo8.setOnCheckedChangeListener(this);
        actinfo9.setOnCheckedChangeListener(this);
        actinfo10.setOnCheckedChangeListener(this);
        actinfo11.setOnCheckedChangeListener(this);
        actinfo12.setOnCheckedChangeListener(this);
        actinfo13.setOnCheckedChangeListener(this);


        lifestatus1=findViewById(R.id.lifestatus1);
        lifestatus2=findViewById(R.id.lifestatus2);
        lifestatus3=findViewById(R.id.lifestatus3);
        lifestatus4=findViewById(R.id.lifestatus4);
        lifestatus5=findViewById(R.id.lifestatus5);
        lifestatus6=findViewById(R.id.lifestatus6);
        lifestatus7=findViewById(R.id.lifestatus7);
        lifestatus8=findViewById(R.id.lifestatus8);
        lifestatus9=findViewById(R.id.lifestatus9);
        lifestatus10=findViewById(R.id.lifestatus10);
        lifestatus11=findViewById(R.id.lifestatus11);
        lifestatus12=findViewById(R.id.lifestatus12);

        lifestatus1.setOnCheckedChangeListener(this);
        lifestatus2.setOnCheckedChangeListener(this);
        lifestatus3.setOnCheckedChangeListener(this);
        lifestatus4.setOnCheckedChangeListener(this);
        lifestatus5.setOnCheckedChangeListener(this);
        lifestatus6.setOnCheckedChangeListener(this);
        lifestatus7.setOnCheckedChangeListener(this);
        lifestatus8.setOnCheckedChangeListener(this);
        lifestatus9.setOnCheckedChangeListener(this);
        lifestatus10.setOnCheckedChangeListener(this);
        lifestatus11.setOnCheckedChangeListener(this);
        lifestatus12.setOnCheckedChangeListener(this);

        displaySetting();



    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onClick(View v) {
        //SharedPreferences sps=getSharedPreferences("dksettingshare", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor=sps.edit();
        editor.putString("nickname",nkname);
        editor.putString("cellnumber",clnumber);
        editor.putString("email",myemail);

        editor.putBoolean("actinfo1",actinfo1.isChecked());
        editor.putBoolean("actinfo2",actinfo2.isChecked());
        editor.putBoolean("actinfo3",actinfo3.isChecked());
        editor.putBoolean("actinfo4",actinfo4.isChecked());
        editor.putBoolean("actinfo5",actinfo5.isChecked());
        editor.putBoolean("actinfo6",actinfo6.isChecked());
        editor.putBoolean("actinfo7",actinfo7.isChecked());
        editor.putBoolean("actinfo8",actinfo8.isChecked());
        editor.putBoolean("actinfo9",actinfo9.isChecked());
        editor.putBoolean("actinfo10",actinfo10.isChecked());
        editor.putBoolean("actinfo11",actinfo11.isChecked());
        editor.putBoolean("actinfo12",actinfo12.isChecked());
        editor.putBoolean("actinfo13",actinfo13.isChecked());

        editor.putBoolean("lifestatus1",lifestatus1.isChecked());
        editor.putBoolean("lifestatus2",lifestatus2.isChecked());
        editor.putBoolean("lifestatus3",lifestatus3.isChecked());
        editor.putBoolean("lifestatus4",lifestatus4.isChecked());
        editor.putBoolean("lifestatus5",lifestatus5.isChecked());
        editor.putBoolean("lifestatus6",lifestatus6.isChecked());
        editor.putBoolean("lifestatus7",lifestatus7.isChecked());
        editor.putBoolean("lifestatus8",lifestatus8.isChecked());
        editor.putBoolean("lifestatus9",lifestatus9.isChecked());
        editor.putBoolean("lifestatus10",lifestatus10.isChecked());
        editor.putBoolean("lifestatus11",lifestatus11.isChecked());
        editor.putBoolean("lifestatus12",lifestatus12.isChecked());
        editor.commit();

        displaySetting();


    }

    public void displaySetting(){

        String snkname=sps.getString("nickname","");
        String sclnumber=sps.getString("cellnumber","");
        String smyemail=sps.getString("email","");
        String sactinfo="";
        String slifestatus="";

        for(int i=1;i<14;i++){
            boolean act=sps.getBoolean("actinfo"+i,false);
            if(act){
                sactinfo+=mactinfo[i-1]+"，";
            }
        }
        if(sactinfo.length()>1){
            sactinfo=sactinfo.substring(0,sactinfo.length()-1);
        }

        for(int i=1;i<13;i++){
            boolean life=sps.getBoolean("lifestatus"+i,false);
            if(life){
                slifestatus+=mlifestatus[i-1]+"，";
            }
        }
        if(slifestatus.length()>1){
            slifestatus=slifestatus.substring(0,slifestatus.length()-1);
        }

        String settingtext=String.format("我的昵称：%s%n我希望接收的活动信息：%s%n我的生活状态：%s%n手机号：%s%nEmail：%s",snkname,sactinfo,slifestatus,sclnumber,smyemail);
        tv_setting.setText(settingtext);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        nkname=nickname.getText().toString();
        clnumber=cellnumber.getText().toString();
        myemail=email.getText().toString();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
