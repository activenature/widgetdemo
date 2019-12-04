package com.example.chdating;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        GridView gridView=findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(GridViewActivity.this));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Log.i("gridview","这是第"+position+"幅图像。");
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
            return  mThumbIds.length;
        }

        @Override
        public Object getItem(int position){
            return position;
        }

        @Override
        public long getItemId(int id){
            return id;
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent){
            ImageView imageView;
            if(convertView==null){
                imageView=new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85,85));
                imageView.setAdjustViewBounds(false);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8,8,8,8);
            }
            else{
                imageView=(ImageView)convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return  imageView;
        }

        private Integer[] mThumbIds={
                R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6
        };
    }

}
