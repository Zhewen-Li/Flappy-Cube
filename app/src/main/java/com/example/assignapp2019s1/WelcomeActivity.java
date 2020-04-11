package com.example.assignapp2019s1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//The structure of the game is learned from 'SpaceInvader' provided in the lecture
//@author Chenyang Pan
public class WelcomeActivity extends AppCompatActivity {
    public static int[] max = {0};

    @Override
    //Weitong Huang
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},250);
        }
        setContentView(R.layout.activity_welcome);
        Button buttonPlay = findViewById(R.id.play);
        buttonPlay.setBackgroundResource(R.mipmap.button);
        difficultyBar();

        try {
            File file= new File(Environment.getExternalStorageDirectory(),"score.txt");
            FileInputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String score= bufferedReader.readLine();

            TextView scoringView = findViewById(R.id.txv_score);
            String scr = "High Score: "+score.trim();
            System.out.println("Hooray: "+scr);
            if (Character.isDigit(score.charAt(0))) max[0] = Integer.valueOf(score);
            scoringView.setText(scr);
            inputStreamReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Chengyang Pan
    public void playGame(View view){
        Log.d("game","button clicked");
        Intent intent = new Intent(this,GameActivity.class); // Don't change
        startActivityForResult(intent, 26);
    }

    //Chengyang Pan
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode == 26 && resultCode == RESULT_OK && data != null){
            int score = data.getIntExtra("Score", 0);
            if (score >= max[0]) max[0] = score;
            TextView scoringView = findViewById(R.id.txv_score);
            String scr = "High Score: " + max[0];
            scoringView.setText(scr);

            try {
                File file = new File(Environment.getExternalStorageDirectory(),"score.txt");
                if(file.exists()){
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream outputStream=new FileOutputStream(file);
                outputStream.write((max[0]+"").getBytes());
                outputStream.flush();
                outputStream.close();
                System.out.println("write");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // Zhewen Li
    public void difficultyBar(){
        SeekBar seekBar = findViewById(R.id.seekBar);
        Toast.makeText(WelcomeActivity.this,
                "Difficulty: "+ (seekBar.getProgress()+1), Toast.LENGTH_SHORT).show();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(WelcomeActivity.this,
                        "Difficulty: "+ (progress+1), Toast.LENGTH_SHORT).show();

                // Liyao Zhang
                // SET GAME LEVEL
                selectDifficulty(progress+1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    //Zhewen Li
    // SELECT GAME DIFFICULTY
    public void selectDifficulty(int level){
        switch(level){
            case 1:
                setLevel(1);
            case 2:
                setLevel(2);
            case 3:
                setLevel(3);
            case 4:
                setLevel(4);
            case 5:
                setLevel(5);
        }

    }

//level creator by Liyao Zhang
    public void setLevel(int l){
        Bird.BIRD_STEP=7+l;

    }

    //Chengyang Pan
    public static void main(String[] args) throws IOException {
        File file = new File("assets/score.txt");
//                if(file.exists()){
//                    file.delete();
//                }
//                file.createNewFile();
        FileWriter writer=new FileWriter(file,false);
        writer.write("3");
        writer.close();
    }
}
