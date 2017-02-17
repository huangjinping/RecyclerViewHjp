package com.de.hjp.recyclerview.news;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.de.hjp.recyclerview.MainActivity;

import org.xml.sax.XMLReader;

/**
 * Created by harrishuang on 2017/2/17.
 */

public class MaxaTagHandler implements Html.TagHandler {
    private int sIndex = 0;
    private  int eIndex=0;
    private final Context mContext;

    public MaxaTagHandler(Context context){
        mContext=context;
    }




    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {

        Log.d("hjp",opening+"====="+tag+"====="+output);
        if (tag.toLowerCase().equals("mxgsa")) {
            if (opening) {
                sIndex=output.length();
            }else {
                eIndex=output.length();
                output.setSpan(new MxgsaSpan(), sIndex, eIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
    private class MxgsaSpan extends ClickableSpan implements View.OnClickListener {
        @Override
        public void onClick(View widget) {
            Toast.makeText(mContext, "widget", Toast.LENGTH_SHORT).show();

            // TODO Auto-generated method stub
            //具体代码，可以是跳转页面，可以是弹出对话框，下面是跳转页面
            mContext.startActivity(new Intent(mContext,MainActivity.class));
        }
    }

}
