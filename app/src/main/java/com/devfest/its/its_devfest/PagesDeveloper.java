package com.devfest.its.its_devfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PagesDeveloper extends AppCompatActivity {
ListView ls ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages_developer);
        ls = (ListView) findViewById(R.id.liste);
        ArrayList arrayList = ModelDevelopper.getDevelopper();
        AdapterDevelopper adapter = new AdapterDevelopper(this,R.layout.itempagedevelopper,arrayList);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    SmsManager sms = SmsManager.getDefault();
                    String num = "22815521";
                    String message = "est ce que vous ete interesse de notre societe";
                    sms.sendTextMessage(num,null,message,null,null);

                }else if(i == 1){
                    SmsManager sms = SmsManager.getDefault();
                    String num = "54328695";
                    String message = "est ce que vous ete interesse de notre societe";
                    sms.sendTextMessage(num,null,message,null,null);
                }else{
                    SmsManager sms = SmsManager.getDefault();
                    String num = "55623778";
                    String message = "est ce que vous ete interesse de notre societe";
                    sms.sendTextMessage(num,null,message,null,null);
                }
                Toast.makeText(PagesDeveloper.this, "SMS Sent successfully !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
