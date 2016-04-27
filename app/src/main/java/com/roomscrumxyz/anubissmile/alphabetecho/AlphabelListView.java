package com.roomscrumxyz.anubissmile.alphabetecho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AlphabelListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabel_list_view);
        /**
         * GET INTENT..
         */
        Intent getIntent = getIntent();
        final String gotoActivity = getIntent.getStringExtra("GOTO");

        View getView = findViewById(R.id.thArrayList);
        Snackbar.make(getView,"โปรดเลือก ตัวอักษรที่คุณหนูๆต้องการ",Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();

        final String[] thStringArr;

        //ListView & adapter.
        final ListView thArrList = (ListView) findViewById(R.id.thArrayList);
        ArrayAdapter<String> adapter;

        thStringArr = getResources().getStringArray(R.array.alphabet_th);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                thStringArr
        );
        thArrList.setAdapter(adapter);

        thArrList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AlphabelListView.this,thStringArr[position] + " " + position,Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

}
