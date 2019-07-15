package com.example.testgame;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int random,random1,random2,random3,random4,newRand,sum,clicked;
    TextView textView,textView2,textView3,textView5;
    int correct=0,total=0,x=0,a=0;
    String tot,cor;
    boolean check =true;

    MediaPlayer mediaPlayer;

    Button button,button1,button2,button3,button4,button5;
    CountDownTimer timer;
    Animation anim;


    public void quest(){
        random = new Random().nextInt(1000);
        random1 = new Random().nextInt(1000);
        random2 = new Random().nextInt(1000);
        random3 = new Random().nextInt(1000);
        random4 = new Random().nextInt(1000);
        sum = random+random1;

        newRand =  new Random().nextInt(4)+1;
        if(newRand==1){
            button1.setText(Integer.toString(sum));
            button2.setText(Integer.toString(random2));
            button3.setText(Integer.toString(random4));
            button4.setText(Integer.toString(random3));

        }
        if(newRand==2){
            button2.setText(Integer.toString(sum));
            button1.setText(Integer.toString(random3));
            button3.setText(Integer.toString(random2));
            button4.setText(Integer.toString(random4));
        }
        if(newRand==3){
            button3.setText(Integer.toString(sum));
            button1.setText(Integer.toString(random4));
            button2.setText(Integer.toString(random2));
            button4.setText(Integer.toString(random3));
        }
        if(newRand==4){
            button4.setText(Integer.toString(sum));
            button1.setText(Integer.toString(random2));
            button2.setText(Integer.toString(random3));
            button3.setText(Integer.toString(random4));
        }
        String sh1 = Integer.toString(random);
        String sh2 = Integer.toString(random1);
        String sh = " + ";

        textView3.setText(sh1+sh+sh2);

    }

    public void pausePlay(View view){
        if(a==1){
        mediaPlayer.pause();
        a=0;
        }
        else{
            mediaPlayer.start();
        a=1;
        }

    }

    public void playGame(View view){

        if(x==1){
        button5 =(Button)findViewById(R.id.button2);
        button5.setVisibility(View.INVISIBLE);
        x=2;
        }
        x=1;
        textView5=(TextView)findViewById(R.id.textView5);
        textView5.setText("Score: 0/0");
        Button button6=(Button)findViewById(R.id.button3);
        button6.setVisibility(View.VISIBLE);
        button = (Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        button1 = (Button)findViewById(R.id.button8);
        button1.setVisibility(View.VISIBLE);
        button2 = (Button)findViewById(R.id.button9);
        button2.setVisibility(View.VISIBLE);
        button3 = (Button)findViewById(R.id.button10);
        button3.setVisibility(View.VISIBLE);
        button4 = (Button)findViewById(R.id.button11);
        button4.setVisibility(View.VISIBLE);
        textView = (TextView)findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setVisibility(View.VISIBLE);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setVisibility(View.VISIBLE);

        timer = new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                if(millisUntilFinished/1000 >9){
                textView.setText(millisUntilFinished/1000 + "s");}
                else{
                    textView.setText("0" + millisUntilFinished/1000 + "s");
                }
            }

            @Override
            public void onFinish() {


                textView.setText("00s");
                timer.cancel();
                button5 =(Button)findViewById(R.id.button2);
                button5.setVisibility(View.VISIBLE);
                cor =Integer.toString(correct);
                tot =Integer.toString(total);
                total=0;
                correct=0;
                textView2.setText("0/0");
                TextView textView4 = (TextView)findViewById(R.id.textView4);
                textView4.clearAnimation();
                textView4.setVisibility(View.INVISIBLE);
                textView5=(TextView)findViewById(R.id.textView5);
                textView5.setVisibility(View.VISIBLE);
                textView5.setText("Score: "+cor+"/"+tot);
            }
        }.start();

       quest();




    }

    public void decider(View view){

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        Button click =(Button) view;

        clicked = Integer.parseInt(click.getTag().toString());
        if(clicked == newRand){
            correct++;
            total++;
            cor =Integer.toString(correct);
            tot =Integer.toString(total);
            textView4.setText("RIGHT ANSWER");
            textView4.setVisibility(View.VISIBLE);
            anim.setDuration(50);
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            textView4.startAnimation(anim);
            textView2.setText(cor +"/"+tot);
            quest();

        }
        else {
            total++;
            tot =Integer.toString(total);
            cor =Integer.toString(correct);
            textView4.setText("WRONG ANSWER");
            textView4.setVisibility(View.VISIBLE);
            textView2.setText(cor +"/"+tot);
            anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(100);
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            textView4.startAnimation(anim);
            quest();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.own);


    }
}
