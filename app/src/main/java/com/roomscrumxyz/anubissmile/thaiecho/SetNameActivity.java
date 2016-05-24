package com.roomscrumxyz.anubissmile.thaiecho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.roomscrumxyz.anubissmile.alphabetecho.R;

public class SetNameActivity extends AppCompatActivity {

    EditText txtName;
    Button btnGo;
    public SharedPreferences sp;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "ใส่ชื่อของหนูๆ", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        txtName = (EditText) findViewById(R.id.txtName);
        btnGo = (Button) findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                if(name != ""){
                    Snackbar.make(v, "ยินดีต้อนรับ " + name, Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();

                    sp = getSharedPreferences("setName", 0);
                    editor = sp.edit();
                    editor.putString("Name", name);
                    editor.commit();

                    Intent goFirstPage = new Intent(SetNameActivity.this, FirstPage.class);
                    startActivity(goFirstPage);
//
                }
            }
        });
    }

}
