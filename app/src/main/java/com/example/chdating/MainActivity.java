package com.example.chdating;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static android.os.Environment.DIRECTORY_DCIM;
import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.DIRECTORY_MOVIES;
import static android.os.Environment.DIRECTORY_MUSIC;
import static android.os.Environment.DIRECTORY_PICTURES;
import static com.example.chdating.LoginService.*;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener,View.OnClickListener,View.OnLongClickListener{

    ArrayAdapter<String>  adapter;
    String hunfou;
    String textofsd;
    String readtext;
    EditText xingming,nianling,shengao,tizhong;
    TextView textofsd1;

    ImageView camera,camera2;

    Button sendRequest;
    TextView showResponse;
    EditText etUsername;
    EditText etPassword;



    private CheckBox musicCkb;
    private CheckBox tripCkb;
    private CheckBox filmCkb;
    private CheckBox gameCkb;
    private TextView result_tv;
    private Button endBtn;
    ArrayList<String> hobbies = new ArrayList<String>();
    Button[] eventbtns=new Button[3];
    private TextView tv_bbs;
    private TextView tv_control;
    private String[] mCharStr={"你吃饭了吗？","今天天气真好呀！","我中奖了呀！","我们去看电影吧。","晚上干什么好呢？"};
    private Button btn_icon;
    private Drawable drawable;
    TextView tv_life;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        camera=findViewById(R.id.camera);
        camera2=findViewById(R.id.camera2);

        eventbtns[0]=findViewById(R.id.button16);
        eventbtns[1]=findViewById(R.id.button17);
        eventbtns[2]=findViewById(R.id.button18);
        eventbtns[0].setOnFocusChangeListener(MainActivity.this);
        eventbtns[1].setOnFocusChangeListener(MainActivity.this);
        eventbtns[2].setOnFocusChangeListener(MainActivity.this);

        musicCkb = (CheckBox) findViewById(R.id.chb_music);
        tripCkb = (CheckBox) findViewById(R.id.chb_trip);
        filmCkb = (CheckBox) findViewById(R.id.chb_film);
        gameCkb = (CheckBox) findViewById(R.id.chb_game);

        tv_life=findViewById(R.id.tv_life);

        result_tv = (TextView) findViewById(R.id.result_tv);
        registerForContextMenu(result_tv);



        endBtn = (Button) findViewById(R.id.end);

        musicCkb.setOnCheckedChangeListener(this);
        tripCkb.setOnCheckedChangeListener(this);
        filmCkb.setOnCheckedChangeListener(this);
        gameCkb.setOnCheckedChangeListener(this);

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hobbies.size(); i++) {
                    if (i == (hobbies.size() - 1)) {
                        sb.append(hobbies.get(i));
                    } else {
                        sb.append(hobbies.get(i) + ",");
                    }
                }
                result_tv.setText("你选择了："+sb);

            }
        });

        //auto-complete-text-view
        Button autobtn=findViewById(R.id.button5);
        autobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AutoCompleteTextViewActivity.class);
                startActivity(intent);
            }
        });




        Button btv=findViewById(R.id.tvbutton);
        btv.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View view){
                setTitle("tvbutton was clicked by user");
                Log.i("widgetDemo","tvbutton was clicked by user");
                TextView textView1=findViewById(R.id.textView1);
                textView1.setText("set up the font of TextView");
                textView1.setTextColor(Color.RED);
                textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                textView1.setTypeface(Typeface.DEFAULT_BOLD);
            }
        });

        final EditText editText=findViewById(R.id.editText1);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                TextView textView1=findViewById(R.id.textView1);
                String text=editText.getText().toString();
                textView1.setText(text);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button spinnerbtn=findViewById(R.id.spbutton);
        spinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        Button timebtn=findViewById(R.id.button6);
        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TimeActivity.class);
                startActivity(intent);
            }
        });

        Button processbtn=findViewById(R.id.button7);
        processbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this,ProcessBarActivity.class);
                startActivity(intent);
            }
        });


        Button seekbtn=findViewById(R.id.button8);
        seekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this,SeekBarActivity.class);
                startActivity(intent);
            }
        });



        Button imgbtn=findViewById(R.id.button10);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this,ImageButtonActivity.class);
                startActivity(intent);
            }
        });

        Button gallerybtn=findViewById(R.id.button11);
        gallerybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });

        Button gridbtn=findViewById(R.id.button12);
        gridbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this,GridViewActivity.class);
                startActivity(intent);
            }
        });

        Button tabbtn=findViewById(R.id.button13);
        tabbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this,TabActivity.class);
                startActivity(intent);
            }
        });

        Button tablayoutbtn=findViewById(R.id.button14);
        tablayoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this, TabLayoutActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        Button bitmapbtn=findViewById(R.id.button15);
        bitmapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this, BitMapActivity.class);
                startActivity(intent);
            }
        });

        TextView densityview=findViewById(R.id.densityview);
        densityview.setText(getScreenInfo(MainActivity.this));

        tv_control=findViewById(R.id.tv_control);
        tv_control.setOnClickListener(this);
        tv_control.setOnLongClickListener(this);
        tv_bbs=findViewById(R.id.tv_bbs);
        tv_bbs.setOnClickListener(this);
        tv_bbs.setOnLongClickListener(this);
        tv_bbs.setMovementMethod(new ScrollingMovementMethod());


        btn_icon=findViewById(R.id.btn_icon);
        drawable=getResources().getDrawable(R.mipmap.ic_launcher,null);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_icon.setCompoundDrawables(drawable,null,null,null);
            }
        });
        findViewById(R.id.btn_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_icon.setCompoundDrawables(null,drawable,null,null);
            }
        });
        findViewById(R.id.btn_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_icon.setCompoundDrawables(null,null,drawable,null);
            }
        });
        findViewById(R.id.btn_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_icon.setCompoundDrawables(null,null,null,drawable);
            }
        });




        Button calbtn=findViewById(R.id.button19);
        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });


        refreshLife("onCreate");


        TextView sdinfo=findViewById(R.id.sdinfo);
        String sddir="系统环境（含SD卡）的信息如下：\n"
                +"  根目录路径：" + Environment.getRootDirectory()
                +"\n  数据目录路径：" +Environment.getDataDirectory()
                +"\n  下载缓存目录路径："+Environment.getDownloadCacheDirectory()
                +"\n  外部存储（即SD卡）目录路径："+Environment.getExternalStorageDirectory()
                +"\n  外部存储（即SD卡）状态："+Environment.getExternalStorageState()
                +"\n  SD卡的相机目录路径："+Environment.getExternalStoragePublicDirectory(DIRECTORY_DCIM)
                +"\n  SD卡的下载目录路径："+Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS)
                +"\n  SD卡的图片目录路径："+Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES)
                +"\n  SD卡的视频目录路径："+Environment.getExternalStoragePublicDirectory(DIRECTORY_MOVIES)
                +"\n  SD卡的音乐目录路径："+Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC);
        sdinfo.setText(sddir);


       List<String> list=new ArrayList<>();
       Spinner hunspinner;

            xingming=findViewById(R.id.xingming);
            nianling=findViewById(R.id.nianling);
            shengao=findViewById(R.id.shengao);
            tizhong=findViewById(R.id.tizhong);
            textofsd1=findViewById(R.id.textofsd);
            list.add("已婚");
            list.add("单身");
            hunspinner=findViewById(R.id.hunspinner);
            adapter=new ArrayAdapter(this,R.layout.my_spinner_item,list);
            adapter.setDropDownViewResource(R.layout.my_dropdown_item);
            hunspinner.setAdapter(adapter);
            hunspinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                    hunfou =adapter.getItem(arg2);
                    arg0.setVisibility(View.VISIBLE);
                }
                public void onNothingSelected(AdapterView<?> arg0){
                    arg0.setVisibility(View.VISIBLE);
                }
            });

        Button savetextbtn=findViewById(R.id.savetext);
        savetextbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               try{

                textofsd =xingming.getText().toString()+"\n"+nianling.getText().toString()+"\n"+shengao.getText().toString()+"\n"+tizhong.getText().toString()+"\n"+hunfou;
//安卓7.0开始对往SD卡写入文件做了严格限制。
                  // PermissionUtils.verifyStoragePermissions(MainActivity.this);
                  /** 下面这段代码的文件的存储位置是data\data\com.*****.*****\files\20191022.txt
                   Context context=MainActivity.this;
                   BufferedOutputStream fos=new BufferedOutputStream(context.openFileOutput("20191022.txt",Context.MODE_PRIVATE));
                    fos.write(textofsd.getBytes());
                    fos.close();

                   BufferedInputStream fis=new BufferedInputStream(context.openFileInput("20191022.txt"));
                   byte[] b=new byte[fis.available()];
                   fis.read(b);
                   readtext =new String(b);
                   fis.close();
                   textofsd1.setText(readtext);  **/

                  /**  下面这段代码的文件存储位置是storage\emulated\0\201910221632.txt
                  String sd=Environment.getExternalStorageDirectory().getAbsolutePath();
                   BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(sd+"/201910221632.txt",false));
                   fos.write(textofsd.getBytes());
                   fos.close();

                   BufferedInputStream fis=new BufferedInputStream(new FileInputStream(sd+"/201910221632.txt"));
                   byte[] b=new byte[fis.available()];
                   fis.read(b);
                   readtext =new String(b);
                   fis.close();
                   textofsd1.setText(readtext);  **/

                   //File sd=MainActivity.this.getFilesDir() 这样就可以获取/data/data/<application package>/files目录。getCacheDir()可以获取/data/data/<application package>/cache目录
                  //下面这段代码的文件的存储地址是/storage/emulated/0/Android/data/<application package>/DIRECTORY_DOCUMENTS类型的文件夹 /files/documents
                   File[] sd=MainActivity.this.getExternalFilesDirs(Environment.DIRECTORY_DOCUMENTS);
                   BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(sd[0]+"/201910221632.txt",false));
                   fos.write(textofsd.getBytes());
                   fos.close();

                   BufferedInputStream fis=new BufferedInputStream(new FileInputStream(sd[0]+"/201910221632.txt"));
                   byte[] b=new byte[fis.available()];
                   fis.read(b);
                   readtext =new String(b);
                   fis.close();
                   textofsd1.setText(readtext);

                }catch (Exception e)
                {
                  e.printStackTrace();
                }

            }
        });

        Button saveimagebtn=findViewById(R.id.saveimage);
        final LinearLayout registerimage=findViewById(R.id.registerimage);
        final ImageView saveimage=findViewById(R.id.registeringimage);
        saveimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //如果需要截图的View还没有显示到界面上或者没有显示过，此时调用DrawingCache方法是获取不到位图的。
                    registerimage.setDrawingCacheEnabled(true);
                    registerimage.setDrawingCacheBackgroundColor(Color.WHITE);
                    registerimage.buildDrawingCache();
                    registerimage.measure(View.MeasureSpec.makeMeasureSpec(registerimage.getWidth(),View.MeasureSpec.EXACTLY),View.MeasureSpec.makeMeasureSpec(registerimage.getHeight(),View.MeasureSpec.EXACTLY));
                    registerimage.layout((int)registerimage.getX(),(int)registerimage.getY(),(int)(registerimage.getX()+registerimage.getMeasuredWidth()),(int)(registerimage.getY()+registerimage.getMeasuredHeight()));
                    Bitmap newbitmap=Bitmap.createBitmap(registerimage.getDrawingCache(),0,0,registerimage.getMeasuredWidth(),registerimage.getMeasuredHeight());
                    registerimage.setDrawingCacheEnabled(false);
                    registerimage.destroyDrawingCache();


//存储地址可能是Android/data/com.example.widgetdemo（以前的包名，现在的是chdating。可能文件夹建立以后就不能更改了。）/files/Pictures
                    File[] imageroute=MainActivity.this.getExternalFilesDirs(DIRECTORY_PICTURES);
                    BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(imageroute[0]+"/注册.jpg"));
                    newbitmap.compress(Bitmap.CompressFormat.JPEG,80,fos);
                    fos.flush();
                    fos.close();

                    BufferedInputStream fis=new BufferedInputStream(new FileInputStream(imageroute[0]+"/注册.jpg"));
                    Bitmap bitmap=null;
                    bitmap=BitmapFactory.decodeStream(fis);
                    saveimage.setImageBitmap(bitmap);
                    fis.close();



                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


        Button saveglobalbtn=findViewById(R.id.saveglobal);
        final TextView globalmemory=findViewById(R.id.globalmemory);
        saveglobalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> n1mInfoMap=MainApplication.getInstance().mInfoMap;
                n1mInfoMap.put("name",xingming.getText().toString());
                n1mInfoMap.put("age",nianling.getText().toString());
                n1mInfoMap.put("height",shengao.getText().toString());
                n1mInfoMap.put("weight",tizhong.getText().toString());
                n1mInfoMap.put("marriage",hunfou);
                n1mInfoMap.put("update_time",(new Date()).toString());

                globalmemory.setText("全局内存中保存的信息如下：\n" +"  name的取值为"+n1mInfoMap.get("name")+"\n"
                +"  age的取值为"+n1mInfoMap.get("age")+"\n"
                +"  height的取值为"+n1mInfoMap.get("height")+"\n"
                +"  weight的取值为"+n1mInfoMap.get("weight")+"\n"
                +"  marriage的取值为"+n1mInfoMap.get("marriage")+"\n"
                +"  update_time的取值为"+n1mInfoMap.get("update_time"));


            }
        });


        Button camerabtn=findViewById(R.id.cameraimage);

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //手机的摄像头应用程序启动失败。安卓7.0需要动态申请权限，并且需要指定相片存储目录。
                    /**Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(intent.resolveActivity(getPackageManager())!=null) {
                        startActivityForResult(intent, 1);
                    }
                    if(intent.resolveActivity(getPackageManager())==null) {
                        Toast.makeText(MainActivity.this,"手机自带的摄像机应用程序没有响应这个Intent", Toast.LENGTH_LONG).show();
                    } **/

                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,1);
                }catch (Exception e){
                    Log.d("cameraDemo",e.toString());
                }
            }
        });


        Button camerabtn2=findViewById(R.id.cameraimage2);

        camerabtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent takePictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    if(takePictureIntent.resolveActivity(getPackageManager())!=null){
                     File photoFile=createImageFile();
                     if(!photoFile.exists()){
                         photoFile.mkdirs();
                     }
                     Uri photoUri= FileProvider.getUriForFile(MainActivity.this,"com.example.widgetdemo.fileprovider",photoFile);

                     takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                       PermissionUtils.verifyCameraPermissions(MainActivity.this);
                     startActivityForResult(takePictureIntent,2);
                    }
                }catch (Exception e){
                   e.printStackTrace();
                }
            }
        });


        ToggleButton checkbtn=findViewById(R.id.checkbutton);
        final TextView checktext=findViewById(R.id.checktext);
        final BroadcastReceiver batreceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(Intent.ACTION_BATTERY_CHANGED.equals(action)){
                    int current=intent.getIntExtra("level",1);
                    int total=intent.getIntExtra("scale",100);
                    int value=current*100/total;
                    checktext.setText("当前电量是"+value+"%");
                }
            }
        };

//两张图片的淡入淡出效果，太费内存，效果很差。
/**    Resources res=getResources();
        final TransitionDrawable transition=(TransitionDrawable)res.getDrawable(R.drawable.expand_collapse);
        camera2.setImageDrawable(transition);
        transition.startTransition(2000);  **/


        checkbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    IntentFilter batfilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                    registerReceiver(batreceiver,batfilter);

                }else{
                    unregisterReceiver(batreceiver);
                    checktext.setText("");
                }
            }
        });



        sendRequest=findViewById(R.id.sendrequest);
        showResponse=findViewById(R.id.response);
        etUsername=findViewById(R.id.username);
        etPassword=findViewById(R.id.password);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String username=etUsername.getText().toString();
                        String password=etPassword.getText().toString();
                        final String response= loginByPost(username,password);
                        if(response!=null){
                            showResponse(response);
                        }else{
                            showResponse("请求失败......");
                        }
                    }
                }).start();
            }
        });


    }

    private void showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showResponse.setText(response);
            }
        });
    }



    String mCurrentPicPath;
    private File createImageFile(){
        String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        String imageFileName="JPEG_"+timeStamp+"_";
        File[] storageDir=MainActivity.this.getExternalFilesDirs(Environment.DIRECTORY_PICTURES);
        File image=null;
        try{
            image=File.createTempFile(imageFileName,".jpg",storageDir[0]);
            mCurrentPicPath=image.getAbsolutePath();
        }catch (Exception e){
            e.printStackTrace();
        }
        return image;
    }


    public void onActivityResult(int requestcode, int resultcode, Intent data){


        if(requestcode==1 && resultcode==RESULT_OK) {
            super.onActivityResult(requestcode, resultcode, data);
            try {
               Uri selectedImage=data.getData();
               String[]  filePathColumn={MediaStore.Images.Media.DATA};
                Cursor cursor=getContentResolver().query(selectedImage,filePathColumn,null,null,null);
                cursor.moveToFirst();
                int columnIndex=cursor.getColumnIndex(filePathColumn[0]);
                String picturePath=cursor.getString(columnIndex);
                cursor.close();
                Bitmap bitmap=BitmapFactory.decodeFile(picturePath);
//相片可能会倒置或方向不对，可以设置一个旋转90度，180度，270度，360度的选择，然后再保存相片。
                camera.setImageBitmap(resizeBitmap(bitmap,0.1f));
                //Glide.with(MainActivity.this).load(picturePath).centerCrop().into(camera);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(requestcode==2 && resultcode==RESULT_OK) {
            super.onActivityResult(requestcode, resultcode, data);
            try {

                Bitmap bitmappic=BitmapFactory.decodeFile(mCurrentPicPath);
                camera2.setImageBitmap(bitmappic);



            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(resultcode!=RESULT_OK){
            Toast.makeText(MainActivity.this,"启动照相机失败", Toast.LENGTH_LONG).show();
        }
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked){
            hobbies.add(buttonView.getText().toString().trim());
        }
        else{
            hobbies.remove(buttonView.getText().toString().trim());
        }
    }


    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){

        menu.add(0,1,0,"item1");
        menu.add(0,2,0,"item2");
        menu.add(0,3,0,"item3");
        super.onCreateContextMenu(menu,v,menuInfo);

    }

    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1: Toast.makeText(MainActivity.this,"天天好心情",Toast.LENGTH_LONG).show();
            break;
            case 2: Toast.makeText(MainActivity.this,"想吃水煮牛肉",Toast.LENGTH_LONG).show();
            break;
            case 3: Toast.makeText(MainActivity.this,"要除草了",Toast.LENGTH_LONG).show();
            break;
            default:break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onFocusChange(View view, boolean arg1) {
        switch(view.getId()){
            case R.id.button16:Toast.makeText(MainActivity.this,"第一个按钮获得了焦点",Toast.LENGTH_LONG).show();
                break;
            case R.id.button17:Toast.makeText(MainActivity.this,"第二个按钮获得了焦点",Toast.LENGTH_LONG).show();
                break;
            case R.id.button18:Toast.makeText(MainActivity.this,"第三个按钮获得了焦点",Toast.LENGTH_LONG).show();
                break;

        }

    }
    public  boolean onKeyDown(int keyCode, KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_A:Toast.makeText(MainActivity.this,"按下字母键A",Toast.LENGTH_LONG).show();
            break;
            case KeyEvent.KEYCODE_B:Toast.makeText(MainActivity.this,"按下字母键B",Toast.LENGTH_LONG).show();
            break;
        }
        return false;
    }

    public  boolean onKeyUp(int keyCode, KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_A:Toast.makeText(MainActivity.this,"松开字母键A",Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_B:Toast.makeText(MainActivity.this,"松开字母键B",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    //@Override
    //public  boolean onTouchEvent(MotionEvent event){
        //switch(event.getAction()){
            //case MotionEvent.ACTION_DOWN:Toast.makeText(MainActivity.this,"手指正在往屏幕上按下",Toast.LENGTH_LONG).show();
            //break;
            //case MotionEvent.ACTION_MOVE:Toast.makeText(MainActivity.this,"手指正在往屏幕上移动",Toast.LENGTH_LONG).show();
            //break;
            //case MotionEvent.ACTION_UP:Toast.makeText(MainActivity.this,"手指正在往屏幕上抬起",Toast.LENGTH_LONG).show();
            //break;
        //}
          // return false;
    //}
    public static String getScreenInfo(Context ctx){
        WindowManager wm=(WindowManager)ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return "当前屏幕的宽度是"+dm.widthPixels+"px,高度是"+dm.heightPixels+"px,像素密度是"+dm.density;
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.tv_control||view.getId()==R.id.tv_bbs){
            int random=(int)(Math.random()*10)%5;
            String newStr=String.format("%s\n%s",tv_bbs.getText().toString(),mCharStr[random]);
            tv_bbs.setText(newStr);
        }
    }

    @Override
    public boolean onLongClick(View view){
        if(view.getId()==R.id.tv_control||view.getId()==R.id.tv_bbs){
            tv_bbs.setText("");
        }
        return true;
    }

    public void refreshLife(String desc){
        Log.d("MainActivity",desc);
        String mStr=String.format("%s%s\n","MainActivity",desc);
        tv_life.setText(mStr);

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


    public static class PermissionUtils{

        private static final int REQUEST_CAMERA=1;
        private static String[] PERMISSIONS_CAMERA={Manifest.permission.CAMERA};
        public static void verifyCameraPermissions(Activity activity){
            int permission= ActivityCompat.checkSelfPermission(activity,Manifest.permission.CAMERA);
            if(permission!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(activity,PERMISSIONS_CAMERA,REQUEST_CAMERA);
            }
        }
    }

private static Bitmap resizeBitmap(Bitmap bitmap,float number){
    Matrix matrix=new Matrix();
    matrix.postScale(number,number);
    Bitmap resizeBmp=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
    return resizeBmp;
}

}