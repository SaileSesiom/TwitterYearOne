package com.sailesesiom.twitteryearone;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class SearchTimeline extends ListActivity implements View.OnClickListener{

    private EditText editTextSearch;
    private Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_timeline);
        asociarObjetos();
        asociarEscuchas();
    }

    private void buscarTweets(String user){
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(user)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }

    private void asociarObjetos() {
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
    }

    private void asociarEscuchas() {
        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSearch:
                buscarTweets(editTextSearch.getText().toString());
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
        if (item.getItemId() == R.id.action_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
