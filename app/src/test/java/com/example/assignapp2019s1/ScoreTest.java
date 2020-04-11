package com.example.assignapp2019s1;

import android.graphics.Paint;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
//Zhewen Li
public class ScoreTest {
    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    Score score1 = new Score(0,99,99,paint1);
    Score score2 = new Score(3,99,99,paint2);

    @Test
    public void scoreTest() {
        assertNotNull(score1);
        assertNotNull(score2);
    }

}

