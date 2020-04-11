package com.example.assignapp2019s1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// @author Zhewen Li
// Unit test for calculation in each class (Bird, Pillar, Pillars)
// the test are based on canvas size of 1080(w) * 1920(h)

public class WhiteBoxTest {
    private Game game = new Game();

    @Test
    public void birdFall(){ // test bird location after falling effect --- if (time >= 3 || !falling)
        Bird bird1 = new Bird(); // --- time =1 && falling == true
        bird1.time = 1;
        bird1.falling =true;
        bird1.step();
        float a1 = bird1.y;

        Bird bird2 = new Bird(); // --- time =1 && falling == false
        bird2.time = 1;
        bird2.falling = false;
        bird2.step();
        bird2.step();
        float a2 = bird2.y;

        Bird bird3 = new Bird(); // --- time =3 && falling == true
        bird3.time = 3;
        bird3.falling = true;
        bird3.step();
        bird3.step();
        bird3.step();
        float a3 = bird3.y;

        Bird bird4 = new Bird(); // --- time =3 && falling == false
        bird4.time = 3;
        bird4.falling = false;
        bird4.step();
        bird4.step();
        bird4.step();
        bird4.step();
        float a4 = bird4.y;

        assertEquals(806.6011962890625, (double) a1, 0.0); // bird position
        assertEquals(1.1, bird1.time, 0.0); // bird falling time
        assertEquals(826.3579711914062, (double) a2, 0.0);
        assertEquals(1.2000000000000002, bird2.time, 0.0);
        assertEquals(849.5447998046875, (double) a3, 0.0);
        assertEquals(1.3000000000000003, bird3.time, 0.0);
        assertEquals(876.4359741210938, (double) a4, 0.0);
        assertEquals(1.4000000000000004, bird4.time, 0.0);
    }

    @Test
    public void birdOut(){  // check when bird is out of screen
       Bird bird1 = new Bird();
       Bird bird2 = new Bird();
       game.step();
       bird1.y = 2080;
       bird2.y = -2;
       assertTrue(game.dead());
    }

}
