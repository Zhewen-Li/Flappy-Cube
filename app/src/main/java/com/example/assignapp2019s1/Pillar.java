package com.example.assignapp2019s1;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

//@author Chenyang Pan
public class Pillar {
    int x ,offset;
    boolean newPillar;
    final float GAP_SIZE=150;           // the gap between two pillars
    final float PILLAR_WIDTH=200;
    boolean passed = false;
    int count = 0;
    public Pillar(){
        newPillar=true;
    }

    //draw a pair of pillars
    public void draw(Canvas c, Paint p){
        int h = c.getHeight();
        int w = c.getWidth();
        if(newPillar){                  // if it is a new pillar, set x and offset
            Random rand = new Random();
            offset= rand.nextInt(800)-400;
            x=w;
            newPillar=false;
        }
        c.drawRect(x,h/2-GAP_SIZE+offset,x+PILLAR_WIDTH,0,p);
        c.drawRect(x,h/2+GAP_SIZE+offset,x+PILLAR_WIDTH,h,p);
    }
}
