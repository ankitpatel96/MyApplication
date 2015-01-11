package ap.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

        int fakeRate = intent.getIntExtra("rate", -1);
        Log.d("Receiver", "Fake Rate Received and is " + fakeRate);
        if (fakeRate != -1){
            MainActivity.heartRate = fakeRate;
        }

    }

}
