package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SemFourHome extends AppCompatActivity implements View.OnClickListener {
    Button JPR,SEN,DCC,MIC;

    public static final String OwnerID = "OwnerID";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem4subjects);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }
        JPR=findViewById(R.id.JPR);
        SEN=findViewById(R.id.SEN);
        DCC=findViewById(R.id.DCC);
        MIC=findViewById(R.id.MIC);


        JPR.setOnClickListener(this);
        SEN.setOnClickListener(this);
        DCC.setOnClickListener(this);
        MIC.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==JPR){

            String sub_name="JPR";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==SEN){

            String sub_name="SEN";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==DCC){

            String sub_name="DCC";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==MIC){

            String sub_name="MIC";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }
    }
}

