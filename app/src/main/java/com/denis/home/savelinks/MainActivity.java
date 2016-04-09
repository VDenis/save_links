package com.denis.home.savelinks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static com.denis.home.savelinks.Utility.copyToClipBoard;

/// Create a link in dropbox app from chrome share intent
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startIntent();
        finish();
    }

    private void startIntent() {
        Intent intent = getIntent();
        if (intent.getAction().equals(Intent.ACTION_SEND)) {

            String text_subject = intent.getStringExtra(Intent.EXTRA_SUBJECT);
            String text_text = intent.getStringExtra(Intent.EXTRA_TEXT);
            Log.d(TAG, "startIntent: " + text_subject);
            Log.d(TAG, "startIntent: " + text_text);

            // Create the text message with a string
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            // TODO: Use EXTRA_SUBJECT or EXTRA_SHORTCUT_NAME, not both
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, text_subject);
            //sendIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, text_subject);
            sendIntent.putExtra(Intent.EXTRA_TEXT, text_text);
            sendIntent.setType("text/plain");
            //sendIntent.setType("application/internet-shortcut");

            copyToClipBoard(MainActivity.this, text_subject);

            // Verify that the intent will resolve to an activity
            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(sendIntent);
            }
        }
    }
}
