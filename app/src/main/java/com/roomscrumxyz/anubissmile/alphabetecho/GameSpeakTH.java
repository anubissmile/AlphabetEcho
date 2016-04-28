package com.roomscrumxyz.anubissmile.alphabetecho;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class GameSpeakTH extends AppCompatActivity {

    /**
     * OBJECT MEDIAPLAYER.
     */
    MediaPlayer mPlayer_th;

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

//            Toast.makeText(GameSpeakTH.this, resultList.get(0), Toast.LENGTH_LONG).show();

        }
    }
    //END OF GOOGLE_SPEECH_RECOGIZER'S METHOD.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_speak_th);

        /**
        * GET INTENT.
        */
        Intent gIntent = getIntent();
        int position = gIntent.getIntExtra("pos_ind",100);
        position++;
        String dName = "t" + Integer.toString(position);
//        Toast.makeText(ListeningTH.this, dName, Toast.LENGTH_SHORT).show();

        /**
         * UI OBJECT BINDING & SHOW IMAGE RESOURCE.
         */
        ImageView mic = (ImageView) findViewById(R.id.mic);
        ImageView alpha_logo = (ImageView) findViewById(R.id.alpha_image_view);
        View alpha_logo_view = findViewById(R.id.alpha_image_view);

        //        int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);

        int id = getResources().getIdentifier("com.roomscrumxyz.anubissmile.alphabetecho:drawable/"+ dName,
                null, null);
        alpha_logo.setImageResource(id);

        Snackbar.make(alpha_logo_view, "กดที่ตัวอักษรเพื่อฟังการออกเสียง...", Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**
                         * DO NOTHING.
                         */
                    }
                })
                .setActionTextColor(Color.GREEN)
                .show();

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
        int rawID = getResources().getIdentifier("com.roomscrumxyz.anubissmile.alphabetecho:raw/"+ dName,
                null, null);
        mPlayer_th = MediaPlayer.create(this, rawID);

        alpha_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer_th.start();
            }
        });

        /**
         * CALL MICROPHONE.
         */
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callVoiceRecognition();
            }
        });
    }
}
