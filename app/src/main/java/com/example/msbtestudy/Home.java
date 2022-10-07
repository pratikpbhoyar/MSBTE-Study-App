package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button s1,s2,s3,s4,s5,s6;
    public static final String OwnerID = "OwnerID";
    public static final String SEM = "SEM";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        s1=findViewById(R.id.sem1);
        s2=findViewById(R.id.sem2);
        s3=findViewById(R.id.sem3);
        s4=findViewById(R.id.sem4);
        s5=findViewById(R.id.sem5);
        s6=findViewById(R.id.sem6);

        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        s6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
if(v==s1){
String sem_name="SEM1";
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString(SEM, sem_name);
    editor.commit();

    Intent i = new Intent(getApplicationContext(),SemOneHome.class);
    startActivity(i);
}else if(v==s2){

    String sem_name="SEM2";
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString(SEM, sem_name);
    editor.commit();
    Intent i = new Intent(getApplicationContext(),SemTwoHome.class);
    startActivity(i);
}else if(v==s3){
    String sem_name="SEM3";
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString(SEM, sem_name);
    editor.commit();
    Intent i = new Intent(getApplicationContext(),SemThreeHome.class);
    startActivity(i);
}else if(v==s4){
    String sem_name="SEM4";
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString(SEM, sem_name);
    editor.commit();
    Intent i = new Intent(getApplicationContext(),SemFourHome.class);
    startActivity(i);
}else if(v==s5){
    String sem_name="SEM5";
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString(SEM, sem_name);
    editor.commit();
    Intent i = new Intent(getApplicationContext(),SemFiveHome.class);
    startActivity(i);
}else if(v==s6){
    String sem_name="SEM6";
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putString(SEM, sem_name);
    editor.commit();
    Intent i = new Intent(getApplicationContext(),SemSixHome.class);
    startActivity(i);
}
    }
}
