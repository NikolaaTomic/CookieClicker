package com.example.projektims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private Button back;
    private Button buy1, buy2, buy3, buy4;
    private TextView txt;
    private ImageView home;
    private TextView ck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        back = (Button) findViewById(R.id.button7);
        buy1 = (Button) findViewById(R.id.buy7);
        buy2 = (Button) findViewById(R.id.buy6);
        buy3 = (Button) findViewById(R.id.buy5);
        buy4 = (Button) findViewById(R.id.buy);
        txt = (TextView) findViewById(R.id.txt);
        home = (ImageView) findViewById(R.id.home);
        ck = (TextView) findViewById(R.id.textView4);

        vrijednost a = new vrijednost();
        txt.setText(a.str);
        ck.setText((a.br) + " Cookies!");


        if(a.p1){
            buy1.setText("Purchased");
            buy1.setEnabled(false);
        }
        if(a.p2){
            buy2.setText("Purchased");
            buy2.setEnabled(false);
        }
        if(a.p3){
            buy3.setText("Purchased");
            buy3.setEnabled(false);
        }
        if(a.p4){
            buy4.setText("Purchased");
            buy4.setEnabled(false);
        }


        View.OnClickListener b1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a.br >= 40){
                    a.p1 = true;
                    a.br = a.br -40;
                    buy1.setText("Purchased");
                    buy1.setEnabled(false);
                    ck.setText((a.br) + " Cookies!");
                }else{
                    Toast.makeText(MainActivity4.this,"Not enough Cookies", Toast.LENGTH_SHORT).show();
                }
            }
        };
        buy1.setOnClickListener(b1);

        View.OnClickListener b2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a.br >= 60){
                    a.p2 = true;
                    a.br = a.br - 60;
                    buy2.setText("Purchased");
                    buy2.setEnabled(false);
                    ck.setText((a.br) + " Cookies!");
                }else{
                    Toast.makeText(MainActivity4.this,"Not enough Cookies", Toast.LENGTH_SHORT).show();
                }
            }
        };
        buy2.setOnClickListener(b2);

        View.OnClickListener b3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a.br >= 80){
                    a.p3 = true;
                    a.br = a.br - 80;
                    buy3.setText("Purchased");
                    buy3.setEnabled(false);
                    ck.setText((a.br) + " Cookies!");
                }else{
                    Toast.makeText(MainActivity4.this,"Not enough Cookies", Toast.LENGTH_SHORT).show();
                }
            }
        };
        buy3.setOnClickListener(b3);

        View.OnClickListener b4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a.br >= 100){
                    a.p4 = true;
                    a.br = a.br - 100;
                    buy4.setText("Purchased");
                    buy4.setEnabled(false);
                    ck.setText((a.br) + " Cookies!");
                }else{
                    Toast.makeText(MainActivity4.this,"Not enough Cookies", Toast.LENGTH_SHORT).show();
                }
            }
        };
        buy4.setOnClickListener(b4);

        View.OnClickListener goback = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent);

            }
        };
        back.setOnClickListener(goback);

        View.OnClickListener ho = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(intent);
            }
        };
        home.setOnClickListener(ho);
    }
}