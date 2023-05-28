package com.example.projektims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity3 extends AppCompatActivity {

    Resources js;
    ArrayAdapter<String> lista;
    AutoCompleteTextView txt;
    TextInputLayout lay;

    private Button btn;
    private EditText txt1, txt2;
    private TextView txtt;
    private ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        lay = (TextInputLayout) findViewById(R.id.inputLayout);
        js = getResources();
        lista = new ArrayAdapter(MainActivity3.this, R.layout.dropdown_item, js.getStringArray(R.array.gender));
        txt.setAdapter(lista);
        btn = (Button) findViewById(R.id.button6);
        txt1 = (EditText) findViewById(R.id.editTextTextPersonName5);
        txt2 = (EditText) findViewById(R.id.editTextTextPersonName4);
        txtt = (TextView) findViewById(R.id.txt);
        home = (ImageView) findViewById(R.id.home);

        vrijednost a = new vrijednost();
        txtt.setText(a.str);

        View.OnClickListener go = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ime = txt1.getText().toString();
                String gma = txt2.getText().toString();
                if(ime.equals("") || gma.equals("")){
                    Toast.makeText(MainActivity3.this, "Trebate unijeti sve podatke", Toast.LENGTH_LONG).show();
                }
                else{
                    a.str = ime;
                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    intent.putExtra("msg", ime);
                    startActivity(intent);
                }
            }
        };
        btn.setOnClickListener(go);

        View.OnClickListener ho = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        };
        home.setOnClickListener(ho);
    }
}