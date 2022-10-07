package com.example.msbtestudy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button l;
    EditText un, p;
    Boolean chkstatus;
    String usernm,password;

    public static final String OwnerID = "OwnerID";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
String UID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.login);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        UID=sharedpreferences.getString(OwnerID,"");
        if(UID.length()<=0 || UID.isEmpty()){

        }else{
            Intent i = new Intent(getApplicationContext(), Home.class);
            startActivity(i);
            finish();
        }
        CheckConnection ch=new CheckConnection();
        chkstatus=ch.checkInternetConnection(getApplicationContext());

        l = findViewById(R.id.submit);
        un = findViewById(R.id.username);
        p = findViewById(R.id.pwd);
        l.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == l) {
            if(chkstatus){

             usernm = un.getText().toString();
             password = p.getText().toString();
            if (usernm.length() <= 0 || usernm.isEmpty()) {
                Toast toast = Toast.makeText(Login.this, "Please Enter Username", Toast.LENGTH_SHORT);
                toast.show();
            } else if (password.length() <= 0 || password.isEmpty()) {
                Toast toast = Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT);
                toast.show();
            } else {

                new BackgroundTaskProcess().execute();
// send username and password to server side
                // www.xyz.com/MSBTE/process_login.php?username=abc&password=          }
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
        public String user_id = "";
        public String singleParsed = "";
        public String statuscode = "NONE";

        private ProgressDialog Dialog = new ProgressDialog(Login.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage("Please Wait..");
            Dialog.setCanceledOnTouchOutside(false);
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... voids) {

            try { usernm= URLEncoder.encode(usernm, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }
            try { password= URLEncoder.encode(password, "UTF-8");} catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }

            try {
                URL url = new URL("http://msbtestudy.online/MSBTE/process_login.php?username="+usernm+"&password="+password+"");
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
                    user_id = JO.getString("user_id");
                }


            } catch (JSONException e) {
                Dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Something Went Wrong, Please Try Again!",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            Dialog.dismiss();
            if(statuscode.equalsIgnoreCase("success")){

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(OwnerID, user_id);
                editor.commit();

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
