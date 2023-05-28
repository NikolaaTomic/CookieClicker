package com.example.projektims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ImageView cookie;
    private TextView ispis;
    int pu = 0;
    private Button shop, login;
    private TextView txt;
    private ImageView home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cookie = (ImageView) findViewById(R.id.imageView);
        ispis = (TextView) findViewById(R.id.textView);
        shop = (Button) findViewById(R.id.button);
        login = (Button) findViewById(R.id.button2);
        txt = (TextView) findViewById(R.id.txt);
        home = (ImageView) findViewById(R.id.home);


        vrijednost a = new vrijednost();

        txt.setText(a.str);

        ispis.setText(String.valueOf(a.br) + " Cookies!");

        View.OnTouchListener novi3 = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    cookie.setScaleX(0.9f);
                    cookie.setScaleY(0.9f);
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    a.br = a.br + 1 + pu;
                    ispis.setText(String.valueOf(a.br) + " Cookies!");
                    cookie.setScaleX(1);
                    cookie.setScaleY(1);
                }
                return true;
            }
        };
        cookie.setOnTouchListener(novi3);

        View.OnClickListener novi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        };
        shop.setOnClickListener(novi);

        if(a.p1){
            pu = 1;
        }

        if(a.p2){
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            a.br = a.br + 1;
                            ispis.setText(String.valueOf(a.br) + " Cookies!");
                        }
                    });
                }
            },0, 2000);
        }

        if(a.p3){
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            a.br = a.br + 3;
                            ispis.setText(String.valueOf(a.br) + " Cookies!");
                        }
                    });
                }
            },0, 2000);
        }

        if(a.p4){
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            a.br = a.br + 6;
                            ispis.setText(String.valueOf(a.br) + " Cookies!");
                        }
                    });
                }
            },0, 2000);
        }

        View.OnClickListener log = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        };
        login.setOnClickListener(log);

        View.OnClickListener ho = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        };
        home.setOnClickListener(ho);


    }


}