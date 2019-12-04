package com.example.chdating;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class GalleryActivity extends Activity {

    private Gallery gallery;
    private ImageSwitcher imageSwitcher;
    private Integer[] resids={R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5
            , R.drawable.img_6, R.drawable.img_7};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        gallery=findViewById(R.id.gallery);
        imageSwitcher=findViewById(R.id.switcher);
        ImageAdapter imageAdapter=new ImageAdapter(GalleryActivity.this);
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                imageSwitcher.setImageResource(resids[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                imageSwitcher.setFactory(new ViewFactory() {
                    @Override
                    public View makeView() {
                        ImageView imageView = new ImageView(GalleryActivity.this);
                        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(100, 100));
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        return imageView;
                        //imageSwitcher.setImageResource(resids[0]);

                    }
                });

               // imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(GalleryActivity.this, android.R.anim.fade_in));
                //imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(GalleryActivity.this, android.R.anim.fade_out));
            }
        });
    }


    public class ImageAdapter extends BaseAdapter{
        private Context mContext;

        public ImageAdapter(Context context){
            mContext=context;
        }

        @Override
        public int getCount(){
            return resids.length;
        }

        @Override
        public Object getItem(int position){
            return position;
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent){
            ImageView imageView;
            if(convertView==null){
                imageView=new ImageView(mContext);
                imageView.setLayoutParams(new Gallery.LayoutParams(100,100));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            else{
                imageView=(ImageView)convertView;
            }
            imageView.setImageResource(resids[position]);
            return  imageView;
        }


        private Integer[] resids={R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5
                , R.drawable.img_6, R.drawable.img_7};


    }

    }