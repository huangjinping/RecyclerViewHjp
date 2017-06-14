package com.de.hjp.recyclerview;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by harrishuang on 2017/5/3.
 */

public class WindowManagerActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox cb;
    private TextView tv;
    private SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windowmanager);
        initView();
        initEvent();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Toast.makeText(this, getSystemBrightness() + "", Toast.LENGTH_SHORT).show();
            changeAppBrightness(getSystemBrightness());
        } else {
            int seekBarProgress = seekBar.getProgress();
            changeAppBrightness(seekBarProgress);
        }
    }

    /**
     * 28      * 初始化监听
     * 29
     */
    private void initEvent() {
        //设置seekBar进度被改变的时候的时间监听
        seekBar.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
        //设置CheckBox的点选监听事件
        cb.setOnCheckedChangeListener(this);
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        seekBar = (SeekBar) findViewById(R.id.seek);
        cb=(CheckBox)findViewById(R.id.cb);
        //设置最大刻度
        seekBar.setMax(255);
        //设置初始的Progress
        seekBar.setProgress(getSystemBrightness());
        //出世设置checkBox为选中状态
        cb.setChecked(true);
        //设置初始的屏幕亮度与系统一致
        changeAppBrightness(getSystemBrightness());
    }

    /**
     * 54      * 获得系统亮度
     * 55      *
     * 56      * @return
     * 57
     */
    private int getSystemBrightness() {
        int systemBrightness = 0;
        try {
            systemBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return systemBrightness;
    }


    /**
     * 69      * 改变App当前Window亮度
     * 70      *
     * 71      * @param brightness
     * 72
     */
    public void changeAppBrightness(int brightness) {
        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        if (brightness == -1) {
            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
        } else {
            lp.screenBrightness = (brightness <= 0 ? 1 : brightness) / 255f;
        }
        window.setAttributes(lp);
    }


    class MyOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //seekBar进度条被改变的时候取消checkBox的点选
            cb.setChecked(false);
            //改变亮度
            changeAppBrightness(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
