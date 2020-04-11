package com.example.assignapp2019s1;

import android.graphics.Canvas;
import android.graphics.Paint;


//@author Chenyang Pan
public class Bird {
    public static final float BIRD_SIZE= 35;  // size of bird (radius of the circle)
    public static float BIRD_STEP=7;  // fall speed of the bird
    float x, y, r;
    double time = 1;
    public static final double GRAVITY = 9.8;
    public boolean falling = true;

    public Bird(){
        x=205;
        y=790;
        r=BIRD_SIZE;
    }

    //Chengyang Pan
    public void draw(Canvas c, Paint p){
        c.drawCircle (x, y,BIRD_SIZE, p);//draw bird
    }
    ////Chengyang Pan
    public void step(){
        if (time >= 3 || !falling) {
            time = 1;
            falling = true;
        }
        time+=0.1;
        //Weitong Huang
        y=y + BIRD_STEP * (float) Math.pow(time, 2) * (float) GRAVITY/5;
    }

}
