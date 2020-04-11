package com.example.assignapp2019s1;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;


//@author Chenyang Pan
public class Pillars extends ArrayList<Pillar> {
    public static final float MOVE_STEP= 15;
    public static final int PILLAR_WIDTH = 200;
    public static final int ADD_NEW_DISTANCE= 500;  //680  used to adjust the distance between pairs of pillars

    // move the pillar forward one step
    public void move(){
        for (Pillar p : this) {
            p.x-=MOVE_STEP;
        }
        Iterator<Pillar> pi = this.iterator();
        while (pi.hasNext()){
            Pillar p = pi.next();
            if(p.x<-PILLAR_WIDTH){
                pi.remove();
            }
        }
        if(this.size()<5){
            Pillar p2=this.get(this.size()-1);
            if(p2.x<ADD_NEW_DISTANCE){
                this.add(new Pillar());
            }
        }
    }

    public void draw(Canvas canvas, Paint paint){
        for(Pillar p : this){
            p.draw(canvas,paint);
        }
    }

}
