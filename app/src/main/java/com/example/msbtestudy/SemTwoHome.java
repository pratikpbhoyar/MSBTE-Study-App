package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SemTwoHome  extends AppCompatActivity implements View.OnClickListener {
    Button EEC,AMI,BEC,PCI;

    public static final String OwnerID = "OwnerID";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem2subjects);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        EEC=findViewById(R.id.EEC);
        AMI=findViewById(R.id.AMI);
        BEC=findViewById(R.id.BEC);
        PCI=findViewById(R.id.PCI);

        EEC.setOnClickListener(this);
        AMI.setOnClickListener(this);
        BEC.setOnClickListener(this);
        PCI.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==EEC){

            String sub_name="EEC";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==AMI){

            String sub_name="AMI";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==BEC){

            String sub_name="BEC";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==PCI){

            String sub_name="PCI";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }
    }
}

