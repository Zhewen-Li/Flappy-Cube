package com.example.assignapp2019s1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

//Weitong huang
public class Score {
    int score;
    float x, y;

    Score(int score, float x, float y, Paint paint) {
        this.score = score;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas) {
        final int COLOUR = Color.BLACK;
        Paint paint= new Paint();
        paint.setColor(COLOUR);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.SERIF);
        canvas.drawText(this.score+"", this.x, this.y, paint); // draw text
    }

    public void add() {
        this.score += 1;
    }
}
