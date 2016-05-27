package com.sailesesiom.twitteryearone;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity implements View.OnClickListener{

    private TextView textViewEmailSaile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.setTitle(R.string.txt_title_acerca_de);
        asociarObjetos();
        asociarEscuchas();
    }

    protected void asociarObjetos() {
        textViewEmailSaile = (TextView) findViewById(R.id.textViewEmailSaile);
    }

    protected void asociarEscuchas() {
        textViewEmailSaile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.textViewEmailSaile){
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("mailto:SaileSesiom@outlook.com"));
            try {
                startActivity(intent);
            } catch (SecurityException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_regresar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}