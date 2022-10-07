package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectHome  extends AppCompatActivity implements View.OnClickListener {
Button lectures,study,quiz;
    public static final String OwnerID = "OwnerID";
    public static final String CATEGORY = "CATEGORY";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID;
TextView subjectname;
    Boolean chkstatus;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectshome);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        String semname =sharedpreferences.getString(SEM,"");
        String subname =sharedpreferences.getString(SUBJECT,"");
        subjectname=findViewById(R.id.subjectname);
        String varsn=semname+" - "+subname+" SUBJECT";
        subjectname.setText(varsn);
        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        CheckConnection ch=new CheckConnection();
        chkstatus=ch.checkInternetConnection(getApplicationContext());



        lectures=findViewById(R.id.Lectures);
        study=findViewById(R.id.Notes);
        quiz=findViewById(R.id.Quiz);


        lectures.setOnClickListener(this);
        study.setOnClickListener(this);
        quiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

if(view==lectures){
    if(chkstatus){

        String cat_name="lectures";
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CATEGORY, cat_name);
        editor.commit();
        Intent i =new Intent(getApplicationContext(),MyWebView.class);
        startActivity(i);

    }else{
        Toast toast = Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT);
        toast.show();
    }
}else if(view==study){
    if(chkstatus){

        String cat_name="study";
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CATEGORY, cat_name);
        editor.commit();
        Intent i =new Intent(getApplicationContext(),MyWebView.class);
        startActivity(i);

    }else{
        Toast toast = Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT);
        toast.show();
    }
}else if(view==quiz){
    if(chkstatus){

        String cat_name="quiz";
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CATEGORY, cat_name);
        editor.commit();
        Intent i =new Intent(getApplicationContext(),MyWebView.class);
        startActivity(i);

    }else{
        Toast toast = Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT);
        toast.show();
    }
}

    }
}
