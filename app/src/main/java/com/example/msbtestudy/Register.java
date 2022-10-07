package com.example.msbtestudy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText name,email,mob,clgnm,city;
    Button sub;
    String var_name,var_email,var_mob,var_clgnm,var_city;
    Boolean chkstatus;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

 CheckConnection ch=new CheckConnection();
        chkstatus=ch.checkInternetConnection(getApplicationContext());

        name=findViewById(R.id.fullname);
        email=findViewById(R.id.emailid);
        mob=findViewById(R.id.mobilenumber);
        clgnm=findViewById(R.id.collegename);
        city=findViewById(R.id.cityname);

        sub=findViewById(R.id.submit);
        sub.setOnClickListener(this);
    }

    @Override
    public void onClick(View e) {
        if(e==sub) {
            if(chkstatus){
            var_name = name.getText().toString();
            var_email = email.getText().toString();
            var_mob = mob.getText().toString();
            var_clgnm = clgnm.getText().toString();
            var_city = city.getText().toString();
            if (var_name.length() <= 0 || var_name.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Full Name", Toast.LENGTH_SHORT);
                toast.show();
            } else if (var_email.length() <= 0 || var_email.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Email ID", Toast.LENGTH_SHORT);
                toast.show();
            } else if (var_mob.length() <= 0 || var_mob.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Mobile Number", Toast.LENGTH_SHORT);
                toast.show();
            } else if (var_clgnm.length() <= 0 || var_clgnm.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Please Enter College name", Toast.LENGTH_SHORT);
                toast.show();
            } else if (var_city.length() <= 0 || var_city.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Please Enter City", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                // send all data to server side
                new BackgroundTaskProcess().execute();
// www.xyz.com/MSBTE/process_register.php?name=abc&email=&mob=&college_name=&city=
            }
        }else{
                Toast toast = Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }



    public class BackgroundTaskProcess extends AsyncTask<String,Void,String> {
        public String data = "";
        public String dataParsed = "";
        public String owner_id = "";
        public String singleParsed = "";
        public String statuscode = "NONE";

        private ProgressDialog Dialog = new ProgressDialog(Register.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage("Please Wait..");
            Dialog.setCanceledOnTouchOutside(false);
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... voids) {

            try { var_name= URLEncoder.encode(var_name, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }
            try { var_email= URLEncoder.encode(var_email, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }
            try { var_mob= URLEncoder.encode(var_mob, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }
            try { var_clgnm= URLEncoder.encode(var_clgnm, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }
            try { var_city= URLEncoder.encode(var_city, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }


            try {
                URL url = new URL("http://msbtestudy.online/MSBTE/process_register.php?name="+var_name+"&email="+var_email+"&mob="+var_mob+"&college_name="+var_clgnm+"&city="+var_city+"");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line+ "\n");
                }
                data = sb.toString().trim();
                bufferedReader.close();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jsonArray = null;
                jsonArray = jsonObject.getJSONArray("server_response");

                for (int i = 0; i< jsonArray.length(); i++){
                    JSONObject JO = null;
                    JO = jsonArray.getJSONObject(i);
                    statuscode = JO.getString("status");
                    dataParsed = JO.getString("msg");
                }


            } catch (JSONException e) {
                Dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Something Went Wrong, Please Try Again!",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            Dialog.dismiss();
            if(statuscode.equalsIgnoreCase("success")){

                Toast.makeText(getApplicationContext(),dataParsed,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
                finish();

            }else if(statuscode.equalsIgnoreCase("error")){
                Toast.makeText(getApplicationContext(),dataParsed,Toast.LENGTH_SHORT).show();
            }
            super.onPostExecute(s);
        }

    }


}
