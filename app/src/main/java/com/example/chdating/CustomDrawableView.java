package com.example.chdating;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;


public class CustomDrawableView extends View {

    private ShapeDrawable mDrawable;

    public CustomDrawableView(Context context){
        super(context);
        int x=10;
        int y=10;
        int width=300;
        int height=50;
        mDrawable=new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff74AC23);
        mDrawable.setBounds(x,y,x+width,y+height);

    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        mDrawable.draw(canvas);
    }

}
