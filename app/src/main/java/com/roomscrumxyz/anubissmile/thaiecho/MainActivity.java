package com.roomscrumxyz.anubissmile.thaiecho;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.roomscrumxyz.anubissmile.alphabetecho.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    /**
     * METHOD FOR GOOGLE SPEECH RECOGNIZER.
     */
    private final static int REQUEST_VOICE_RECOGNITION = 10001;
    private void callVoiceRecognition(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "th-TH");
        startActivityForResult(intent, REQUEST_VOICE_RECOGNITION);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_VOICE_RECOGNITION &&
                resultCode == RESULT_OK &&
                data != null) {
            ArrayList<String> resultList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            Toast.makeText(MainActivity.this, resultList.get(0) , Toast.LENGTH_LONG).show();
        }
    }
    //END OF GOOGLE_SPEECH_RECOGIZER'S METHOD.

    MediaPlayer mPlayer_th;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * OBJECT UI BINDING
         */
        Button spelling_btn = (Button) findViewById(R.id.spelling_btn);
        Button listening_btn = (Button) findViewById(R.id.listening_btn);
        ImageView logo_thai_flag = (ImageView) findViewById(R.id.logo_thai_flag);

        /**
         * MAKE OBJECT MEDIAPLAYER
         */
        if (mPlayer_th != null) {
            /**
             * CHECK FOR MEDIA PLAYER STATUS.
             */
            mPlayer_th.stop();
            mPlayer_th.release();
        }

        /**
         * CREATE MEDIAPLAYER ROUTE.
         */
        mPlayer_th = MediaPlayer.create(this, R.raw.t1);

        /**
         * SPELLING_BTN SET ONCLICK -> THEN MAKE SNACKBAR
         */
        spelling_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ก.ไก่", Toast.LENGTH_LONG).show();
                mPlayer_th.start();
            }
        });

        /**
         * LISTENING_BTN SET ONCLICK -> THEN MAKE TOAST
         */
        listening_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                callVoiceRecognition();
                Snackbar.make(v, "กำลังฟัง...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**
         * LOGO_THAI_FLAG SET ONCLICK -> THEN MAKE TOAST
         */
        logo_thai_flag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You Click the logo", Toast.LENGTH_LONG).show();
                Snackbar.make(v, "กำลังฟัง...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**
         * FLOATING ACTIOIN BUTTON MENU
         * */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.roomscrumxyz.anubissmile.alphabetecho/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.roomscrumxyz.anubissmile.alphabetecho/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
