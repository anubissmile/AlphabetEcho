package com.roomscrumxyz.anubissmile.alphabetecho;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        /**
         * UI OBJECT BINDING.
         */
        ImageButton listening_btn = (ImageButton) findViewById(R.id.listening_btn);
        ImageButton speek_out_btn = (ImageButton) findViewById(R.id.speek_out_btn);

        /**
         * PERFORM UI ON EVENT.
         */

        //listening button
        listening_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "ไปฟังการอ่าน...", Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();
            }
        });

        //speek out button
        speek_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "ไปฝึกการออกเสียงด้วยเกมส์กันเถอะ...", Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();
            }
        });

    }
}
