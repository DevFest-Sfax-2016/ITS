package com.devfest.its.its_devfest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainAuth extends AppCompatActivity {
    Button dev, ste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_auth);
        dev= (Button) findViewById(R.id.button_dev);
        ste= (Button) findViewById(R.id.button_ste);

        //action btn

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainAuth.this, LoginDev.class));
                finish();
            }
        });

        //ste

        ste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainAuth.this, Loginste.class));
                finish();
            }
        });
    }
}
