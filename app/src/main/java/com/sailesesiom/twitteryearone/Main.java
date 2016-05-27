package com.sailesesiom.twitteryearone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.TextView;
import android.widget.Toast;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import android.util.Log;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.TwitterAuthToken;

public class Main extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
//    private TextView textView;
    private TwitterLoginButton loginButton;
    private FloatingActionButton fab;
    private TwitterSession session;

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "E5wb4dB4mFYtOaWnmpyoplla1";
    private static final String TWITTER_SECRET = "kHZn0CEeEkU77dMjWDcrQge0cfhc0cbaI3kWS6hy0aEyZR69Jq";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        autorizarConfiguracion();
        setContentView(R.layout.activity_main);
        asociarObjetos();
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        asociarEscuchas();

        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Log.d("Twitter", "Login Sucessfull");
                //session = result.data;
                session = Twitter.getInstance().core.getSessionManager().getActiveSession();

//                String username = "Hi, ";
//                username += session.getUserName();
//                textView.setText(username);

                String msg = "@" + session.getUserName() + ", logged in !";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;

                Intent intent = new Intent(Main.this, TimeLine.class);
                intent.putExtra("user", session.getUserName());
                intent.putExtra("consumerKey", token);
                intent.putExtra("consumerSecret", secret);
                startActivity(intent);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login con Twitter Fallido !", exception);
            }
        });
    }

    public void autorizarConfiguracion(){
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fab){
            final View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            };
            Snackbar.make(view, R.string.txt_email_author, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.txt_action_close, clickListener).show();
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("mailto:SaileSesiom@outlook.com"));
            try {
                startActivity(intent);
            }
            catch (SecurityException se) {
                se.printStackTrace();
            }
        }
    }

    private void asociarObjetos() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        textView = (TextView) findViewById(R.id.tv_username);
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    protected void asociarEscuchas() {
        fab.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_acerca_de:
                intent = new Intent(Main.this, AcercaDe.class);
                startActivity(intent);
                break;
            case R.id.action_webgrafia:
                intent = new Intent(Main.this, Webgrafia.class);
                startActivity(intent);
                break;
            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
