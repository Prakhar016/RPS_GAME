package com.example.dmv.rpsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock , b_paper , b_scissor;
    ImageView iv_cpu ,iv_me;
    String mychoice , cpuchoice , result;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissor = (Button) findViewById(R.id.b_scissor);

        r = new Random();


        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mychoice = "ROCK";
                iv_me.setImageResource(R.drawable.r);
                calculate();
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mychoice = "PAPER";
                iv_me.setImageResource(R.drawable.p);
                calculate();
            }
        });
        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mychoice = "SCISSOR";
                iv_me.setImageResource(R.drawable.s);
                calculate();
            }
        });
    }

    public void calculate(){
        int cpu = r.nextInt(3);
        if(cpu == 0){
            cpuchoice = "ROCK";
            iv_cpu.setImageResource(R.drawable.r);
        } else if(cpu == 1){
            cpuchoice = "PAPER";
        iv_cpu.setImageResource(R.drawable.p);
        }
        else if(cpu == 2){
            cpuchoice = "SCISSOR";
        iv_cpu.setImageResource(R.drawable.s);
        }

        if(mychoice.equals("ROCK") && cpuchoice.equals("PAPER")){
            result = "YOU LOSE!";
        }else
        if(mychoice.equals("ROCK") && cpuchoice.equals("SCISSOR")){
            result = "YOU WIN!";
        }else
        if(mychoice.equals("PAPER") && cpuchoice.equals("ROCK")){
            result = "YOU WIN!";
        }else
        if(mychoice.equals("PAPER") && cpuchoice.equals("SCISSOR")){
            result = "YOU LOSE!";
        }else
        if(mychoice.equals("SCISSOR") && cpuchoice.equals("PAPER")){
            result = "YOU WIN!";
        }else
        if(mychoice.equals("SCISSOR") && cpuchoice.equals("ROCK")){
            result = "YOU LOSE!";
        }else
        if(mychoice.equals("SCISSOR") && cpuchoice.equals("SCISSOR")){
            result = "DRAW!";}else
            if(mychoice.equals("ROCK") && cpuchoice.equals("ROCK")){
                result = "DRAW!";}else
                if(mychoice.equals("PAPER") && cpuchoice.equals("PAPER")){
                    result = "DRAW!";}
        Toast.makeText(MainActivity.this, result , Toast.LENGTH_SHORT).show();
    }
}
