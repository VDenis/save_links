package com.denis.home.savelinks;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String createInternetShortcut(String input) {
        return "[InternetShortcut]\n"
                + "URL=" + input;
    }

    /**
     <p>Parse and get url from link like: <br/>"I'm enjoying 【Google】 | https://www.google.ru/?gfe_rd=cr&ei=LfueWMjOIon07gSL5pHYCQ vvvvvv https://www.google.ru/?gfe_rd=cr&ei=LfueWMjOIon07gSL5pHYCB vvvv"</p>
     <p>Result: <br/>"https://www.google.ru/?gfe_rd=cr&ei=LfueWMjOIon07gSL5pHYCB"</p>
    */
    public static String getUrlFromText(String input) {
        String pattern = "^.*((https|http)[.\\S]*)";
        Pattern patt = Pattern.compile(pattern);
        Matcher matcher = patt.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
