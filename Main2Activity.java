package com.example.user.thepiggame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    int roundScore, activePlayer;
    boolean gamePlaying;
    int[] scores = new int[2];


    public void roll(View view){


        if(gamePlaying){

            ImageView image = (ImageView) view;
            Random random = new Random();
            int dice = random.nextInt(5) + 1;
            switch(dice){
                case 1:image.setImageResource(R.drawable.dice1);

                    break;
                case 2:image.setImageResource(R.drawable.dice2);

                    break;
                case 3:image.setImageResource(R.drawable.dice3);

                    break;
                case 4:image.setImageResource(R.drawable.dice4);

                    break;
                case 5:image.setImageResource(R.drawable.dice5);

                    break;
                case 6:image.setImageResource(R.drawable.dice6);

            }


            if(dice!=1){
                roundScore+=dice;

                if (activePlayer==0){
                    TextView text = (TextView) findViewById(R.id.p1score);
                    text.setText("CURRENT SCORE\n     "+roundScore);}
                else{
                    TextView text = (TextView) findViewById(R.id.p2score);
                    text.setText("CURRENT SCORE\n     "+roundScore);}


            }else{

                nextplayer();
            }
        }
    }

    public void hold(View view){
        if(gamePlaying){

            scores[activePlayer]+=roundScore;
            if (activePlayer==0){
                TextView text = (TextView) findViewById(R.id.p1total);
                text.setText("TOTAL SCORE\n   "+scores[activePlayer]);}
            else{
                TextView text = (TextView) findViewById(R.id.p2total);
                text.setText("TOTAL SCORE\n   "+scores[activePlayer]);}

            if(scores[0]>=100){
                TextView text = (TextView) findViewById(R.id.p1);
                text.setText("WINNER!!");
                gamePlaying=false;
            }
            else{

                if(scores[1]>=100){
                    TextView text = (TextView) findViewById(R.id.p2);
                    text.setText("WINNER!!");
                    gamePlaying=false;
                }else {
                    nextplayer();
                }
            }
        }

    }

    public void nextplayer(){
        if(activePlayer==0){ activePlayer=1;}
        else{activePlayer=0;}
        roundScore=0;
        TextView text1 = (TextView) findViewById(R.id.p1score);
        text1.setText("CURRENT SCORE\n     "+roundScore);
        TextView text2 = (TextView) findViewById(R.id.p2score);
        text2.setText("CURRENT SCORE\n     "+roundScore);

    }
    public void newgame(View view){

        init();

    }

    public void init(){
        scores[0]=0;
        scores[1]=0;
        roundScore=0;
        activePlayer=0;

        gamePlaying=true;

        TextView text1 = (TextView) findViewById(R.id.p1total);
        text1.setText("TOTAL SCORE\n  "+roundScore);
        TextView text2 = (TextView) findViewById(R.id.p2total);
        text2.setText("TOTAL SCORE\n  "+roundScore);
        TextView text3 = (TextView) findViewById(R.id.p1score);
        text3.setText("CURRENT SCORE\n     "+roundScore);
        TextView text4 = (TextView) findViewById(R.id.p2score);
        text4.setText("CURRENT SCORE\n     "+roundScore);
        TextView text5 = (TextView) findViewById(R.id.p1);
        text5.setText("PLAYER 1");
        TextView text6 = (TextView) findViewById(R.id.p2);
        text6.setText("PLAYER 2");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

    }
}

