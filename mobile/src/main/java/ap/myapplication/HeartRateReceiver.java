package ap.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Krish on 1/10/2015.
 */
public class HeartRateReceiver extends BroadcastReceiver{

    // Prevents instantiation
    public HeartRateReceiver() {

    }
    // Called when the BroadcastReceiver gets an Intent it's registered to receive

    public void onReceive(Context context, Intent intent) {

        /*
         * Handle Intents here.
         */

        int heartRate = intent.getIntExtra("com.example.android.HeartRate.STATUS", -1);
        Log.d("Receiver", "Fake Rate Received and is " + heartRate);
        if (heartRate != -1){
          if(heartRate > 800){
              String number = "510-364-9907";

              String uri = "tel:" + number.trim() ;
              Intent CallIntent = new Intent(Intent.ACTION_CALL);
              CallIntent.setData(Uri.parse(uri));
              CallIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              context.startActivity(CallIntent);
              Log.d("calling", "called");


        }
        }

        //start activity
        Intent i = new Intent();


    }




}


