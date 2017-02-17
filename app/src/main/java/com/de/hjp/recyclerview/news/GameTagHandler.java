package com.de.hjp.recyclerview.news;

import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/**
 * Created by harrishuang on 2017/2/17.
 */

public class GameTagHandler implements Html.TagHandler {
    private int startIndex = 0;
    private int stopIndex = 0;

    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        if (tag.toLowerCase().equals("g")) {
            if (opening) {
                startGame(tag, output, xmlReader);
            } else {
                endGame(tag, output, xmlReader);
            }
        }
    }

    public void startGame(String tag, Editable output, XMLReader xmlReader) {
        String cc;
        try {
            cc = (String) xmlReader.getProperty("color");
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
        }
        startIndex = output.length();
    }

    public void endGame(String tag, Editable output, XMLReader xmlReader) {
        stopIndex = output.length();
        output.setSpan(new GameSpan(), startIndex, stopIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        String cc;
        try {
            cc = (String) xmlReader.getProperty("color");



        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private class GameSpan extends ClickableSpan implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.e("asdf", "sdsdfs");
        }
    }
}