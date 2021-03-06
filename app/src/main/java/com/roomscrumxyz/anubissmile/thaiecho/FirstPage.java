package com.roomscrumxyz.anubissmile.thaiecho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.roomscrumxyz.anubissmile.alphabetecho.R;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        SharedPreferences sp = getSharedPreferences("setName", 0);
        String name = sp.getString("Name", "").toString();
        setTitle("สวัสดี " + name);

        /**
         * UI OBJECT BINDING.
         */
        ImageButton listening_btn = (ImageButton) findViewById(R.id.listening_btn);
        ImageButton speak_out_btn = (ImageButton) findViewById(R.id.speek_out_btn);
        ImageButton our_team = (ImageButton) findViewById(R.id.our_team_btn);

        /**
         * SET INTENT
         */
        final Intent newActivity = new Intent(FirstPage.this,AlphabelListView.class);

        /**
         * PERFORM UI ON EVENT.
         */
        //listening button
        listening_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "ไปฟังการอ่าน...", Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();
                newActivity.putExtra("GOTO", 11);
                startActivity(newActivity);
            }
        });

        //speek out button
        speak_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "ไปฝึกการออกเสียงด้วยเกมส์กันเถอะ...", Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();
                newActivity.putExtra("GOTO", 22);
                startActivity(newActivity);
            }
        });

        our_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOurTeam = new Intent(FirstPage.this, OurTeamActivity.class);
                startActivity(intentOurTeam);
            }
        });

    }
}
