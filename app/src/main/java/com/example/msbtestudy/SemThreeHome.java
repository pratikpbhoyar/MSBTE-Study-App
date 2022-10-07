package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SemThreeHome  extends AppCompatActivity implements View.OnClickListener {
    Button OOP,DSU,CGR,DMS,DTE;

    public static final String OwnerID = "OwnerID";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem3subjects);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        OOP=findViewById(R.id.OOP);
        DSU=findViewById(R.id.DSU);
        CGR=findViewById(R.id.CGR);
        DMS=findViewById(R.id.DMS);
        DTE=findViewById(R.id.DTE);

        OOP.setOnClickListener(this);
        DSU.setOnClickListener(this);
        CGR.setOnClickListener(this);
        DMS.setOnClickListener(this);
        DTE.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==OOP){

            String sub_name="OOP";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==DSU){

            String sub_name="DSU";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==CGR){

            String sub_name="CGR";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==DMS){

            String sub_name="DMS";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==DTE){

            String sub_name="DTE";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }
    }
}

