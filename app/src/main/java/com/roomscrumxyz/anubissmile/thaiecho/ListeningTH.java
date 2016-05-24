package com.roomscrumxyz.anubissmile.thaiecho;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.roomscrumxyz.anubissmile.alphabetecho.R;

public class ListeningTH extends AppCompatActivity {

    MediaPlayer mPlayer_th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_th);

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
        ImageView alpha_logo = (ImageView) findViewById(R.id.alpha_image_view);
        View alpha_logo_view = findViewById(R.id.alpha_image_view);

//        int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);

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
        int rawID = getResources().getIdentifier("com.roomscrumxyz.anubissmile.thaiecho:raw/"+ dName,
                null, null);
        mPlayer_th = MediaPlayer.create(this, rawID);

        /**
         * PLAY MEDIA ON CLICK.
         */
        alpha_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer_th.start();
            }
        });
    }

}
