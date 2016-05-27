package com.sailesesiom.twitteryearone;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Webgrafia extends AppCompatActivity implements View.OnClickListener{

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webgrafia);
        super.setTitle(R.string.txt_title_webgrafia);
        asociarObjetos();
        setObjetos();
        asociarEscuchas();
    }

    private void asociarObjetos() {
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
    }

    private void setObjetos(){
        textView1.setText(R.string.txt_textview_1);
        textView2.setText(R.string.txt_textview_2);
        textView3.setText(R.string.txt_textview_3);
        textView4.setText(R.string.txt_textview_4);
        textView5.setText(R.string.txt_textview_5);
        textView6.setText(R.string.txt_textview_6);
        textView7.setText(R.string.txt_textview_7);
        textView8.setText(R.string.txt_textview_8);
        textView9.setText(R.string.txt_textview_9);
    }

    protected void asociarEscuchas() {
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        textView9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.textView1:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://apps.twitter.com/"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://get.fabric.io"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.maestrosdelweb.com/curso-android-trabajando-apis-facebook-twitter/"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView4:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/mttkay/signpost/blob/master/docs/TwitterAndSignpost.md"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView5:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.adictosaltrabajo.com/tutoriales/twitter-client-android/"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView6:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://docs.fabric.io/android/twitter/index.html"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView7:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://blog.uchceu.es/informatica/wp-content/uploads/sites/15/2015/01/Tutorial-cliente-Twitter-para-Android.pdf"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView8:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.androidwarriors.com/2015/11/twitter-login-android-studio-example.html"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
            case R.id.textView9:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.SaileSesiom.com/TwitterYearOne"));
                try {
                    startActivity(intent);
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_regresar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
