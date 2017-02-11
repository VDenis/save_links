package com.denis.home.savelinks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denis on 11.02.2017.
 */
public class UtilityTest {

    static final String actualUrl = "https://www.google.ru/?gfe_rd=cr&ei=LfueWMjOIon07gSL5pHYCB";
    static final String text = "I'm enjoying 【Google】 | https://www.google.ru/?gfe_rd=cr&ei=LfueWMjOIon07gSL5pHYCQ vvvvvv https://www.google.ru/?gfe_rd=cr&ei=LfueWMjOIon07gSL5pHYCB vvvv";


    @Test
    public void getUrlFromText() throws Exception {
        String result = Utility.getUrlFromText(text);
        assertEquals(actualUrl, result);
    }

    @Test
    public void getUrlFromTextWithError() throws Exception {
        String result = Utility.getUrlFromText("");
        assertEquals("", result);
    }

}