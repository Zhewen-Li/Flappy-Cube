package com.example.assignapp2019s1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//@author Chenyang Pan
public class GameActivity extends AppCompatActivity implements GameOver{
    @Override
    //Chengyang Pan
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        setContentView(R.layout.activity_game);

        GameView gameView = findViewById(R.id.gameView);
        gameView.registerGameOver(this);
    }

    @Override
    //Chengyang Pan
    public void gameOver() {
        Intent intent = new Intent(GameActivity.this, WelcomeActivity.class);
        GameView gameView = findViewById(R.id.gameView);
        intent.putExtra("Score", gameView.game.score_int.score);
        setResult(RESULT_OK, intent);
        finish();
    }

}
