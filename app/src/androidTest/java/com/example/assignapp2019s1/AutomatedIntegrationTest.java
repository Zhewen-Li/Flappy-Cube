package com.example.assignapp2019s1;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

// @Zhewen Li
// Automated Test
// UI Automated WhiteBox Test
// check whether welcome_activity and game_activity are displayable & actionable

@RunWith(AndroidJUnit4.class)
public class AutomatedIntegrationTest {
    ActivityTestRule<WelcomeActivity> welcomeTestRule = new ActivityTestRule<>(WelcomeActivity.class);
    ActivityTestRule<GameActivity> gameTestRule = new ActivityTestRule<>(GameActivity.class);

    @Test
    public void testWelcomeView() throws NullPointerException{ // check current view if is welcome
        welcomeTestRule.launchActivity(new Intent());
        onView(withId(R.id.welcome)).check(matches(isDisplayed()));
    }

    @Test
    public void testseekbarView() throws NullPointerException{
        welcomeTestRule.launchActivity(new Intent());
        onView(withId(R.id.seekBar)).check(matches(isDisplayed()));
    }

    @Test
    public void testGif() throws NullPointerException{
        welcomeTestRule.launchActivity(new Intent());
        onView((withId(R.id.gifImageView))).check(matches(isDisplayed()));
    }

    @Test
    public void onPressWelcomeView() throws NullPointerException{ // check whether current view is clickable
        welcomeTestRule.launchActivity(new Intent());
        onView(withId(R.id.welcome)).check(matches(isDisplayed())).perform(click());
    }

    @Test
    public void testGameView() throws NullPointerException{ // check current view if is gameview
        gameTestRule.launchActivity(new Intent());
        onView(withId(R.id.gameView)).check(matches(isDisplayed()));
    }

    @Test
    public void onPressGameView() throws Exception{ // check whether current view is clickable
        gameTestRule.launchActivity(new Intent());
        onView(withId(R.id.gameView)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.gameView)).check(matches(isDisplayed()));

    }
}

