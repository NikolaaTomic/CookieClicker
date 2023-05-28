package com.example.projektims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    private Button btn1, btn2, btn3;
    private ImageView img1, img2, img3, img4, img5;
    private int screenWidth;
    private int screenHeight;
    private float yayX, img2X, img3X, img4X, img5X;
    private float yayY, img2Y, img3Y, img4Y, img5Y;
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1 = (Button) findViewById(R.id.button3);
        btn2 = (Button) findViewById(R.id.button4);
        btn3 = (Button) findViewById(R.id.button5);
        img1 = (ImageView) findViewById(R.id.imageView4);
        img2 = (ImageView) findViewById(R.id.imageView5);
        img3 = (ImageView) findViewById(R.id.imageView6);
        img4 = (ImageView) findViewById(R.id.imageView7);
        img5 = (ImageView) findViewById(R.id.imageView8);

        View.OnClickListener play = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btn1.setOnClickListener(play);

        View.OnClickListener login = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        };
        btn2.setOnClickListener(login);

        View.OnClickListener shop = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        };
        btn3.setOnClickListener(shop);


        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        img1.setX(-80.0f);
        img1.setY(screenHeight + 80.0f);
        img2.setX(-80.0f);
        img2.setY(screenHeight + 80.0f);
        img3.setX(-80.0f);
        img3.setY(screenHeight + 80.0f);
        img4.setX(-80.0f);
        img4.setY(screenHeight + 80.0f);
        img5.setX(-80.0f);
        img5.setY(screenHeight + 80.0f);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 10);

    }

    public void changePos(){
        yayY += 10;
        if(img1.getY() > screenHeight){
            yayX = (float)Math.floor(Math.random()*(screenWidth - img1.getWidth()));
            yayY = -100.0f;
        }
        img1.setX(yayX);
        img1.setY(yayY);

        img2Y += 15;
        if(img2.getY() > screenHeight){
            img2X = (float)Math.floor(Math.random()*(screenWidth - img2.getWidth()));
            img2Y = -120.0f;
        }
        img2.setX(img2X);
        img2.setY(img2Y);

        img3Y += 10;
        if(img3.getY() > screenHeight){
            img3X = (float)Math.floor(Math.random()*(screenWidth - img3.getWidth()));
            img3Y = -130.0f;
        }
        img3.setX(img3X);
        img3.setY(img3Y);

        img4Y += 15;
        if(img4.getY() > screenHeight){
            img4X = (float)Math.floor(Math.random()*(screenWidth - img4.getWidth()));
            img4Y = -110.0f;
        }
        img4.setX(img4X);
        img4.setY(img4Y);

        img5Y += 20;
        if(img5.getY() > screenHeight){
            img5X = (float)Math.floor(Math.random()*(screenWidth - img5.getWidth()));
            img5Y = -140.0f;
        }
        img5.setX(img5X);
        img5.setY(img5Y);
    }
}