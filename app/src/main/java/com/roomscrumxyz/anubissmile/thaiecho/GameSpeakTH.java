package com.roomscrumxyz.anubissmile.thaiecho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.roomscrumxyz.anubissmile.alphabetecho.R;

import java.util.ArrayList;

public class GameSpeakTH extends AppCompatActivity {

    /**
     * SHARED PREFERENCE PROPERTY.
     */
    private String spName;

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

//            Toast.makeText(GameSpeakTH.this, "Speech : " + resultList.get(0), Toast.LENGTH_LONG).show();

            /**
             * GET SPEECH & TEXT COMPARISION.
             */
            String[] alpha_chk1,alpha_chk2,alpha_chk3;
            String res = resultList.get(0);

            alpha_chk1 = getResources().getStringArray(R.array.alphabet_th);
            alpha_chk2 = getResources().getStringArray(R.array.alphabet_th_speak);
            alpha_chk3 = getResources().getStringArray(R.array.alphabet_th_speak2);

//          Toast.makeText(GameSpeakTH.this, alpha_chk1[3], Toast.LENGTH_LONG).show();
//          Toast.makeText(GameSpeakTH.this, alpha_chk2[3], Toast.LENGTH_LONG).show();
//          Toast.makeText(GameSpeakTH.this, alpha_chk3[3], Toast.LENGTH_LONG).show();


            /**
             * GET INTENT.
             */
            Intent gIntent = getIntent();
            int position = gIntent.getIntExtra("pos_ind", 100);
            String dName,statusTxt = null;
            int status_speech = 0;

//            Toast.makeText(GameSpeakTH.this, "Position : " + Integer.toString(position), Toast.LENGTH_LONG).show();

            if (res.equals(alpha_chk1[position]) || res.equals(alpha_chk2[position]) ||
                    res.equals(alpha_chk3[position])) {
//                Toast.makeText(GameSpeakTH.this, "Collect", Toast.LENGTH_LONG).show();
                dName = "win_bell";
                status_speech = 1;
                statusTxt = "เยี่ยมมาก " + spName + "! ออกเสียงดีมากไปข้ออื่นกันเล้ย!";
            } else {
//                Toast.makeText(GameSpeakTH.this, "Incollect", Toast.LENGTH_LONG).show();
                dName = "wrong_buzzer";
                status_speech = 2;
                statusTxt = spName + " ยังออกเสียงไม่ถูกต้อง \n กรุณาลองใหม่อีกครั้ง!";
            }
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
            int rawID = getResources().getIdentifier("com.roomscrumxyz.anubissmile.thaiecho:raw/" + dName,
                    null, null);
            mPlayer_th = MediaPlayer.create(this, rawID);
            mPlayer_th.start();

            /**
             * MAKE SNACK BAR.
             */
            View mic = findViewById(R.id.mic);
            final int finalStatus_speech = status_speech;

            Snackbar.make(mic, statusTxt, Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(finalStatus_speech == 1){
                                GameSpeakTH.this.onBackPressed();
                            }
                        }
                    })
                    .setActionTextColor(Color.GREEN)
                    .show();
            //END OF SPEECH & TEXT COMPARISION.

        }
    }
    //END OF GOOGLE_SPEECH_RECOGIZER'S METHOD.

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * GET SHARED PREFERENCE.
         */
        SharedPreferences sp = getSharedPreferences("setName", 0);
        spName = sp.getString("Name", "").toString();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_speak_th);


        /**
         * GET INTENT.
         */
        Intent gIntent = getIntent();
        int position = gIntent.getIntExtra("pos_ind",100);
        position++;
        final String dName = "t" + Integer.toString(position);

        /**
         * UI OBJECT BINDING & SHOW IMAGE RESOURCE.
         */
        ImageView mic = (ImageView) findViewById(R.id.mic);
        ImageView alpha_logo = (ImageView) findViewById(R.id.alpha_image_view);
        View alpha_logo_view = findViewById(R.id.alpha_image_view);

        //        int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);

//        Toast.makeText(ListeningTH.this, dName, Toast.LENGTH_SHORT).show();
        int id = getResources().getIdentifier("com.roomscrumxyz.anubissmile.thaiecho:drawable/"+ dName,
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

        alpha_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rawID = getResources().getIdentifier("com.roomscrumxyz.anubissmile.thaiecho:raw/"+ dName,
                        null, null);
                if(mPlayer_th != null){
                    mPlayer_th.stop();
                    mPlayer_th.release();
                }
                mPlayer_th = MediaPlayer.create(GameSpeakTH.this, rawID);
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
