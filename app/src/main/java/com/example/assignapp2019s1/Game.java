package com.example.assignapp2019s1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

//@author Chenyang Pan
public class Game {
    //edit some values to fit level function by liyao
    public static final float BIRD_UP = 150;    // the rising step of the bird when the screen is touched
    private float canvas_height;    // the height of the canvas(screen)
    private float canvas_width;   // width of the canvas(screen)
    private Pillars pillars;       // a list of 'Pillar'
    private Bird bird;
    public Score score_int;
    public final float SCORE_X = 500;
    public final float SCORE_Y = 200;
    public static final int TEXT_COLOUR = Color.BLACK;


    // initialize game
    public Game(){
        bird=new Bird();
        pillars=new Pillars();
        pillars.add(new Pillar());
        Paint paint = new Paint();
        paint.setColor(TEXT_COLOUR);
        score_int=new Score(0, SCORE_X, SCORE_Y, paint);
    }

    //Chengyang Pan
    // draw game
    public void draw(Canvas canvas, Paint paint){
        canvas_height=canvas.getHeight();
        canvas_width=canvas.getWidth();
        bird.draw(canvas,paint);
        pillars.draw(canvas,paint);
        score_int.draw(canvas);
    }

    //Chengyang Pan
    // move game forward one step
    public void step(){
        pillars.move();
        bird.step();
        for (Pillar p : pillars) {
            if (p.x > 0 && p.x <= canvas_width && p.x < bird.x - bird.r - p.PILLAR_WIDTH/1.5 && p.count == 0 && !p.passed) {
                p.passed = true;
                p.count = 1;
                score_int.add();
            }
        }
    }

    //Chengyang Pan
    // if the screen is touched
    public void touch(){
        bird.falling = false;
        bird.y-=BIRD_UP;
    }

    //Chengyang Pan
    // check the bird is dead or not
    public boolean dead(){
        float bird_x = bird.x;
        float bird_y = bird.y;
        float bird_size= bird.r*bird.r;
        if(bird_y<0||bird_y>canvas_height){   // the bird hit the floor or hit the ceiling
            return true;
        }
        int i =0;

        for (Pillar p : pillars){
            i=i+1;
            float yUp = canvas_height/2-p.GAP_SIZE+p.offset;
            float yDown = canvas_height/2+p.GAP_SIZE+p.offset;
            float xleft= p.x;
            float xright = p.x+p.PILLAR_WIDTH;
            if(xright <bird_x-bird.r|| xleft > bird_x + bird.r) {
                continue;
            }
            float distance1 = (bird_x-xleft)*(bird_x-xleft)+(bird_y-yUp)*(bird_y-yUp);
            float distance2 = (bird_x-xleft)*(bird_x-xleft)+(bird_y-yDown)*(bird_y-yDown);
            float distance3 = (bird_x-xright)*(bird_x-xright)+(bird_y-yUp)*(bird_y-yUp) ;
            float distance4 = (bird_x-xright)*(bird_x-xright)+(bird_y-yDown)*(bird_y-yDown);
            // check whether the bird hit the corners of the pillar or not
            if((distance1<bird_size||distance2<bird_size||distance3<bird_size||distance4<bird_size) && xleft!=0){
                return true;
            }
            if(bird_x>xleft-bird.r && bird_x<xright){
                // if the bird is between two ceilings
                if(bird_x>xleft&& (bird_y-bird.r<yUp || bird_y+bird.r>yDown)) {
                    return true;
                }else if(bird_y> yDown || bird_y < yUp) {       // if the bird hit the left side of the pillar
                    return true;
                }
            }
        }
        return false;
    }

    // Zhewen Li
    // only for testing
    public ArrayList<Float> parameter(float canvas_height, int offset, int x){
        ArrayList<Float> result = new ArrayList<>();
        float yUp = canvas_height/2-150+offset;
        float yDown = canvas_height/2+150+offset;
        float xleft= x;
        float xright = x+200;

        result.add(0,xleft);
        result.add(1,xright);
        result.add(2,yUp);
        result.add(3,yDown);

        return result;

    }

    // Zhewen Li
    // only for testing
    public ArrayList<Float> distance(float canvas_height, int offset, int x, float bird_x, float bird_y){
        ArrayList<Float> result = new ArrayList<>();
        float yUp = canvas_height/2-150+offset;
        float yDown = canvas_height/2+150+offset;
        float xleft= x;
        float xright = x+200;

        float distance1 = (bird_x-xleft)*(bird_x-xleft)+(bird_y-yUp)*(bird_y-yUp);
        float distance2 = (bird_x-xleft)*(bird_x-xleft)+(bird_y-yDown)*(bird_y-yDown);
        float distance3 = (bird_x-xright)*(bird_x-xright)+(bird_y-yUp)*(bird_y-yUp) ;
        float distance4 = (bird_x-xright)*(bird_x-xright)+(bird_y-yDown)*(bird_y-yDown);

        result.add(0,distance1);
        result.add(1,distance2);
        result.add(2,distance3);
        result.add(3,distance4);

        return result;
    }

    // Zhewen Li
    // recode from above only for testing
    public Boolean hitConer(float distance1, float distance2, float distance3, float distance4, float xleft){
        if((distance1<1225||distance2<1225||distance3<1225||distance4<1225) && xleft!=0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean hitLeft(float bird_x, float bird_y, float xleft, float xright, float yUp, float yDown){
        if(bird_x>xleft-bird.r && bird_x<xright) {
            // if the bird is between two ceilings
            if (bird_x > xleft && (bird_y - bird.r < yUp || bird_y + bird.r > yDown)) {
                return true;
            } else if (bird_y > yDown || bird_y < yUp) {       // if the bird hit the left side of the pillar
                return true;
            }
        }
        return false;
    }
}
