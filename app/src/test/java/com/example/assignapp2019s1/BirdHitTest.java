package com.example.assignapp2019s1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

//@author Zhewen Li
// White Box Unit test for checking whether bird hits the pillar
public class BirdHitTest {
    Game game = new Game();

    @Test
    public void testParameter1() throws NullPointerException{ // check whther parameters for calculate distance are correct
        /*
            pillar.x = 130; pillar.offset = 200;
                                                   */
        ArrayList<Float> floats = game.parameter(1920,200,130);
        assertEquals(floats.get(0),130.0,0.0);
        assertEquals(floats.get(1),330.0,0.0);
        assertEquals(floats.get(2),1010.0,0.0);
        assertEquals(floats.get(3),1310.0,0.0);

    }
    @Test
    public void testParameter2() throws NullPointerException{
         /*
            pillar.x = 700; pillar.offset = 490;
                                                   */
        ArrayList<Float> floats = game.parameter(1920,490,700);
        assertEquals(floats.get(0),700.0,0.0);
        assertEquals(floats.get(1),900.0,0.0);
        assertEquals(floats.get(2),1300.0,0.0);
        assertEquals(floats.get(3),1600.0,0.0);
    }

    @Test
    public void testParameter3() throws NullPointerException{
         /*
            pillar.x = 100; pillar.offset = 100;
                                                   */
        ArrayList<Float> floats = game.parameter(1920,100,100);
        assertEquals(floats.get(0),100.0,0.0);
        assertEquals(floats.get(1),300.0,0.0);
        assertEquals(floats.get(2),910.0,0.0);
        assertEquals(floats.get(3),1210.0,0.0);
    }

    @Test
    public void testDistance1() throws NullPointerException{
         /*
            pillar.x = 130; pillar.offset = 200;
                bird.x = 120; bird.y = 500;
                                                   */
        ArrayList<Float> floats = game.distance(1920,200,130,120,500);
        assertEquals(floats.get(0),260200.0,0.0);
        assertEquals(floats.get(1),656200.0,0.0);
        assertEquals(floats.get(2),304200.0,0.0);
        assertEquals(floats.get(3),700200.0,0.0);

    }

    @Test
    public void testDistance2() throws NullPointerException{
         /*
            pillar.x = 700; pillar.offset = 490;
                bird.x = 100; bird.y = 800;
                                                   */
         ArrayList<Float> floats = game.distance(1920,490,700,100,800);
         assertEquals(floats.get(0),610000.0,0.0);
         assertEquals(floats.get(1),1000000.0,0.0);
         assertEquals(floats.get(2),890000.0,0.0);
         assertEquals(floats.get(3),1280000.0,0.0);

    }

    @Test
    public void testDistance3() throws NullPointerException{
         /*
            pillar.x = 200; pillar.offset = 10;
                bird.x = 200; bird.y = 400;
                                                   */
        ArrayList<Float> floats = game.distance(1920,10,200,200,400);
        assertEquals(floats.get(0),176400.0,0.0);
        assertEquals(floats.get(1),518400.0,0.0);
        assertEquals(floats.get(2),216400.0,0.0);
        assertEquals(floats.get(3),558400.0,0.0);

    }

    @Test
    public void hitTest()throws NullPointerException{
        assertEquals(game.hitConer(260200,656200,304200,700200,130),false);
        assertEquals(game.hitConer(610000,1000000,890000,1280000,700),false);
        assertEquals(game.hitConer(176400,518400,216400,558400,100),false);

        assertEquals(game.hitLeft(120,500,130,330,1010,1310),true);
        assertEquals(game.hitLeft(100,800,700,900,1300,1600),false);
        assertEquals(game.hitLeft(200,400,100,300,910,1210),true);
    }
}
