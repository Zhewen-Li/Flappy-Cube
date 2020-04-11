package com.example.assignapp2019s1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import android.os.Handler;

import java.util.ArrayList;

// The structure for this part is learned from 'SpaceInvader'
//@author Chenyang Pan
public class GameView extends View implements View.OnClickListener, Runnable{
    public static final int COLOUR = Color.GREEN;
    public static final int STEPDELAY = 100;
    public static final float DEFAULTPENWIDTH = 3.0f;
    Paint paint;
    Handler repaintHandler;
    Game game;
    ArrayList<GameOver> observers;

    public GameView(Context context, AttributeSet attrs){
        super(context,attrs);

        paint= new Paint();
        paint.setColor(COLOUR);
        paint.setStrokeWidth(DEFAULTPENWIDTH);
        this.setOnClickListener(this);
        observers=new ArrayList<>();
        game= new Game();
        repaintHandler=new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        game.draw(canvas,paint);
    }

    // move the game one step further and check whether the bird is dead or not
    public boolean step(){
        game.step();
        if(game.dead()){
            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }

    private void notifyGameOver() {
        for (GameOver o : observers) {
            o.gameOver();
        }
    }

    @Override
    public void run() {
        if(step()){
            repaintHandler.postDelayed(this,GameView.STEPDELAY);
        }
    }

    public void registerGameOver(GameOver gameover) {
        observers.add(gameover);
    }

    @Override
    public void onClick(View v) {
        game.touch();
    }
}
