package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SemOneHome extends AppCompatActivity implements View.OnClickListener {
    Button ENG,Physics,Chemistry,BasicMathematics;

    public static final String OwnerID = "OwnerID";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem1subjects);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        ENG=findViewById(R.id.ENG);
        Physics=findViewById(R.id.Physics);
        Chemistry=findViewById(R.id.Chemistry);
        BasicMathematics=findViewById(R.id.BasicMathematics);

        ENG.setOnClickListener(this);
        Physics.setOnClickListener(this);
        Chemistry.setOnClickListener(this);
        BasicMathematics.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==ENG){

            String sub_name="ENG";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==Physics){

            String sub_name="Physics";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==Chemistry){

            String sub_name="Chemistry";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==BasicMathematics){

            String sub_name="BasicMathematics";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }
    }
}
