package com.de.hjp.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by harrishuang on 2016/12/6.
 */

public class NIDEMODE extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextView(this));
    }
}
