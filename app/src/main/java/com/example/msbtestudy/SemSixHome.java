package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SemSixHome extends AppCompatActivity implements View.OnClickListener {
    Button MAN,PWP,MAD,ETI,WBP,NIS;


    public static final String OwnerID = "OwnerID";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem6subjects);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }
        MAN=findViewById(R.id.MAN);
        PWP=findViewById(R.id.PWP);
        MAD=findViewById(R.id.MAD);
        ETI=findViewById(R.id.ETI);
        WBP=findViewById(R.id.WBP);
        NIS=findViewById(R.id.NIS);


        MAN.setOnClickListener(this);
        PWP.setOnClickListener(this);
        MAD.setOnClickListener(this);
        ETI.setOnClickListener(this);
        WBP.setOnClickListener(this);
        NIS.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==MAN){


            String sub_name="MAN";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();


            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==PWP){


            String sub_name="PWP";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==MAD){

            String sub_name="MAD";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==ETI){

            String sub_name="ETI";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==WBP){

            String sub_name="WBP";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }else if(view==NIS){

            String sub_name="NIS";
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(SUBJECT, sub_name);
            editor.commit();

            Intent i =new Intent(getApplicationContext(),SubjectHome.class);
            startActivity(i);

        }
    }
}

