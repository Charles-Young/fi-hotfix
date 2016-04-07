package cay.tempfifix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import eu.chainfire.libsuperuser.Shell;

public class RestoreDataState extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = context.getSharedPreferences("preShutdownDataState", context.MODE_PRIVATE);
        boolean mobileDataEnabled = prefs.getBoolean("DataState", false);
        String str;
        if (mobileDataEnabled) {
            str = "enable";
        } else {
            str = "disable";
        }
        Log.v("Restoring Data State", "Restoring toggle to pre-shutdown state...");
        Shell.SU.run("svc data " + str);
        Log.v("Restoring Data State", "Data state " + str + "d");
    }
}
