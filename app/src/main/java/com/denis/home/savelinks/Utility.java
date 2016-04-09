package com.denis.home.savelinks;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Denis on 09.04.2016.
 */
public class Utility {
    public static void copyToClipBoard(Context context, String textToCopy)
    {
        ClipboardManager clipMan = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(context.getString(R.string.page_name_label), textToCopy);
        clipMan.setPrimaryClip(clip);

        Toast.makeText(context, R.string.copy_toast, Toast.LENGTH_SHORT).show();
    }
}
