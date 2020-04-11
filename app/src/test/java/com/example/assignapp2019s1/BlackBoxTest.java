package com.example.assignapp2019s1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

//@author Zhewen Li
// Black Box Unit test for previously testing each Class that is executable(not null when calling)
public class BlackBoxTest {
    private Game game = new Game();

    @Test
    public void testA(){ // test whether bird is moving
        Bird bird = new Bird();
        game.step();
        assertNotEquals(bird.x,0);
        game.touch();
        assertNotEquals(bird.y,0);
    }

    @Test
    public void testB(){ // test whether bird flipped when touching the screen
        Bird bird = new Bird();
        game.step();
        game.touch();
        assertNotEquals(bird.y,0);
    }

    @Test
    public void testC(){
        Pillar pillar = new Pillar();
        Pillars pillars = new Pillars();
        pillars.add(pillar);
        pillar.x = 1080;
        pillars.add(pillar);
        pillars.move();
        assertNotEquals(pillar.x,0);
        assertEquals(pillar.count,0);
        assertNotEquals(pillar.passed,0);
    }
}
