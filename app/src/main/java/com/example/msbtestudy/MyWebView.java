package com.example.msbtestudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MyWebView  extends AppCompatActivity {
    WebView wv1;

    public static final String OwnerID = "OwnerID";
    public static final String CATEGORY = "CATEGORY";
    public static final String SEM = "SEM";
    public static final String SUBJECT = "SUBJECT";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String UID,sem,category,subject;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        UID=sharedpreferences.getString(OwnerID,"");
        sem=sharedpreferences.getString(SEM,"");
        category=sharedpreferences.getString(CATEGORY,"");
        subject=sharedpreferences.getString(SUBJECT,"");


        if(UID.length()<=0 || UID.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }else if(sem.length()<=0 || sem.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }else if(category.length()<=0 || category.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }else if(subject.length()<=0 || subject.isEmpty()){

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        wv1 = (WebView) findViewById(R.id.webview);
        wv1.setWebViewClient(new MyBrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl("http://msbtestudy.online/MSBTE/load_data.php?userid="+UID+"&sem="+sem+"&subject="+subject+"&category="+category+"");
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
