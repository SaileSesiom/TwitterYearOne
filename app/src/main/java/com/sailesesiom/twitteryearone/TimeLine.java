package com.sailesesiom.twitteryearone;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import java.io.File;
import android.view.View;
import android.widget.Button;

public class TimeLine extends ListActivity implements View.OnClickListener{

    private Button buttonTwittear;
    private Button buttonSearch;
    private Button buttonRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        asociarObjetos();
        asociarEscuchas();
        showTimeLine();
    }

    private void autorizarComposer(){
        TwitterAuthConfig authConfig =  new TwitterAuthConfig(getIntent().getStringExtra("consumerKey"),
                getIntent().getStringExtra("consumerSecret"));
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());
    }

    private void tweetComposer(){
        File myImageFile = new File("/path/to/image");
        Uri myImageUri = Uri.fromFile(myImageFile);
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Twiteando desde TwitterYearOne by SaileInc")
                .image(myImageUri);
        builder.show();
    }

    private void showTimeLine(){
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(getIntent().getStringExtra("user"))
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }

    private void asociarObjetos() {
        buttonTwittear = (Button) findViewById(R.id.buttonTwittear);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonRefresh = (Button) findViewById(R.id.buttonRefresh);
    }

    private void asociarEscuchas() {
        buttonTwittear.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        buttonRefresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTwittear:
                autorizarComposer();
                tweetComposer();
                break;

            case R.id.buttonSearch:
                Intent intent;
                intent = new Intent(TimeLine.this, SearchTimeline.class);
                startActivity(intent);
                break;

            case R.id.buttonRefresh:
                showTimeLine();
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
