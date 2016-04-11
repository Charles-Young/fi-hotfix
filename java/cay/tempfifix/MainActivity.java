package cay.tempfifix;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import eu.chainfire.libsuperuser.Shell;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRadioInfo();
            }
        });
        (new RootCheck()).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private class RootCheck extends AsyncTask<Void, Boolean, Boolean> {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Checking for Root...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected Boolean doInBackground(Void... params) {
            // Shell.SU.available is a blocking call and thus should be run on a async task
            return Shell.SU.available();
        }
        protected void onPostExecute(Boolean hasRoot) {
            if (hasRoot){
                progressDialog.dismiss();
            } else {
                progressDialog.dismiss();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Root Check Failed");
                alertDialog.setMessage("This application requires root in order to function.");
                alertDialog.setCancelable(false);
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        });
                alertDialog.show();
            }
        }
    }
    public void jumpSprint(View v) {
        // Only works when android.permission.CONTROL_INCALL_EXPERIENCE is not a system protected permission or when the application is installed in /System.
        // sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://34777")));
        Snackbar.make(v, "Jumping to Sprint", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        (new jumpSprint()).execute();
    }
    private class jumpSprint extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // Shell.SU.run is a blocking call and thus should be run on a async task
            Shell.SU.run("am broadcast -a android.provider.Telephony.SECRET_CODE -d android_secret_code://34777");
            return null;
        }
    }
    public void jumpTMobile(View v) {
        // Only works when android.permission.CONTROL_INCALL_EXPERIENCE is not a system protected permission or when the application is installed in /System.
        // sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://34866")));
        Snackbar.make(v, "Jumping to T-Mobile", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        (new jumpTMobile()).execute();
    }
    private class jumpTMobile extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // Shell.SU.run is a blocking call and thus should be run on a async task
            Shell.SU.run("am broadcast -a android.provider.Telephony.SECRET_CODE -d android_secret_code://34866");
            return null;
        }
    }
    public void nextcarrier(View v) {
        // Only works when android.permission.CONTROL_INCALL_EXPERIENCE is not a system protected permission or when the application is installed in /System.
        // sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://346398")));
        Snackbar.make(v, "Switching to next carrier", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        (new nextcarrier()).execute();
    }
    private class nextcarrier extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // Shell.SU.run is a blocking call and thus should be run on a async task
            Shell.SU.run("am broadcast -a android.provider.Telephony.SECRET_CODE -d android_secret_code://346398");
            return null;
        }
    }
    public void autoswitch(View v) {
        // Only works when android.permission.CONTROL_INCALL_EXPERIENCE is not a system protected permission or when the application is installed in /System.
        // sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://342886")));
        Snackbar.make(v, "Re-enabling network auto switch", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        (new autoswitch()).execute();
    }
    private class autoswitch extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // Shell.SU.run is a blocking call and thus should be run on a async task
            Shell.SU.run("am broadcast -a android.provider.Telephony.SECRET_CODE -d android_secret_code://342886");
            return null;
        }
    }
    public void repair(View v) {
        // Only works when android.permission.CONTROL_INCALL_EXPERIENCE is not a system protected permission or when the application is installed in /System.
        // sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://34963")));
        Snackbar.make(v, "Starting automated network repair", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        (new repair()).execute();
    }
    private class repair extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // Shell.SU.run is a blocking call and thus should be run on a async task
            Shell.SU.run("am broadcast -a android.provider.Telephony.SECRET_CODE -d android_secret_code://34963");
            return null;
        }
    }
    public void launchCurrentInfo(View v) {
        // Only works when android.permission.CONTROL_INCALL_EXPERIENCE is not a system protected permission or when the application is installed in /System.
        // sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://344636")));
        Snackbar.make(v, "Opening Current Network Info", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        (new launchCurrentInfo()).execute();
    }
    private class launchCurrentInfo extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            // Shell.SU.run is a blocking call and thus should be run on a async task
            Shell.SU.run("am broadcast -a android.provider.Telephony.SECRET_CODE -d android_secret_code://344636");
            return null;
        }
    }
    private void launchRadioInfo() {
        Intent link = new Intent(Intent.ACTION_MAIN);
        ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.RadioInfo");
        link.setComponent(cn);
        startActivity(link);
    }
}
