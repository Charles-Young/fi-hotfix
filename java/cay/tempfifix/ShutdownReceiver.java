package cay.tempfifix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.util.Log;

import java.lang.reflect.Method;

import eu.chainfire.libsuperuser.Shell;

public class ShutdownReceiver extends BroadcastReceiver {
    boolean mobileDataEnabled = false; // Assume disabled
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = context.getSharedPreferences("preShutdownDataState", context.MODE_PRIVATE);

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class cmClass = Class.forName(cm.getClass().getName());
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
            // get the setting for "mobile data"
            mobileDataEnabled = (Boolean)method.invoke(cm);
        } catch (Exception e) {
            Log.e("Error", "Error checking data state", e);
        }
        String str = String.valueOf(mobileDataEnabled);

        Log.v("Shutdown Data State", str);
        Log.v("Setting Shared Pref", "Saving Data State...");

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("DataState", mobileDataEnabled);
        editor.apply();

        Log.v("Setting Shared Pref", "Data State Saved.");
        Log.v("Cellular Data", "Enabling Cellular Data Connection...");

        Shell.SU.run("svc data enable");

        Log.v("Cellular Data", "Cellular Data Enabled.");
    }
}
