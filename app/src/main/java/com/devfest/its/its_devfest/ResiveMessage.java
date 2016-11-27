package com.devfest.its.its_devfest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

/**
 * Created by jihed on 27/11/2016.
 */

public class ResiveMessage extends BroadcastReceiver {
    final SmsManager mysms = SmsManager.getDefault();
    static  int id;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        try {
            if(bundle != null){
                final  Object[] messageContent  = (Object[]) bundle.get("pdus");
                for(int i = 0;i<messageContent.length;i++){
                    SmsMessage mysnewms = SmsMessage.createFromPdu((byte[]) messageContent[i] );
                    NewMessageNotification none  = new NewMessageNotification();
                    none.notify(context,mysnewms.getDisplayOriginatingAddress(),mysnewms.getDisplayMessageBody(),id);
                    id++;
                }

            }

        }catch (Exception ex ){
            ex.printStackTrace();
        }

    }
}
