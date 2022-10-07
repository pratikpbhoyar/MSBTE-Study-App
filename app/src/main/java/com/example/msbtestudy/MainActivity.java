package com.example.msbtestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.login);
        a.setOnClickListener(this);

        b=findViewById(R.id.reg);
        b.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view==a){
            Intent i = new Intent(getApplicationContext(),Login.class);
            startActivity(i);
        }else if(view==b){
            Intent i = new Intent(getApplicationContext(),Register.class);
            startActivity(i);
        }
    }
}
