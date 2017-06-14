package com.de.hjp.recyclerview.timer;

import android.util.Log;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 全局定时任务类
 */
public class TimedTask {
    public abstract interface TimedTaskListener {

        // 系统级定时器，回调中不能有耗时操作
        // 比如网络请求等应另起线程,这里边只是发起请求
        public abstract void onTimedTask(int recLen);
    }

    public int recLen = 11;

    public int getRecLen() {
        return recLen;
    }

    public void setRecLen(int recLen) {
        this.recLen = recLen;
    }

    private static final boolean DEBUG = false/*Defs.DEBUG*/;
    private static final String TAG = TimedTask.class.getName();

    // 最小定时器间隔，暂定10″
    private static final long TIMER_PERIOD = 1000;


    private static boolean isSetLooper = false;

    private static TimedTask instance;

    public static TimedTask getTimedTask() {
        if (instance == null) {
            instance = new TimedTask();
        }
        return instance;
    }

    private Timer timer = null;

    private boolean isStart = false;

    private ArrayList<TimedTaskListener> mTaskList = new ArrayList<TimedTaskListener>();

    private TimedTask() {
    }

    // 开始定时任务
    public void start() {
        System.out.println("=====>task111>>>>>1");
        if (isStart) {
            return;
        }
        System.out.println("=====>task111>>>>>2");

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                System.out.println("=====>task111>>>>>3");

                try {
                    recLen--;
                    int count = mTaskList.size();
                    for (int i = 0; i < count; ++i) {
                        System.out.println("=====>task111>>>>>4");
                        mTaskList.get(count - i - 1).onTimedTask(recLen);
                    }
                    if (DEBUG) {
                        Log.v(TAG, "timer run. listener count: " + mTaskList.size());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000, TIMER_PERIOD);
        isStart = true;
    }

    // 结束定时任务
    public void stop() {
        if (DEBUG) {
        }

        if (timer != null) {
            timer.cancel();
        }

        isStart = false;
    }

    // 添加定时任务监听器
    public void requestListener(TimedTaskListener listener) {

        synchronized (this) {
            if (mTaskList != null) {
                mTaskList.add(listener);
            }
        }
    }


    //  删除定时任务监听器
    public void removeListener(TimedTaskListener listener) {

        synchronized (this) {
            if (mTaskList != null) {
                mTaskList.remove(listener);
            }
        }


    }

    public boolean isListener(TimedTaskListener listener) {
        boolean b = false;
        synchronized (this) {
            if (mTaskList != null) {
                b = mTaskList.contains(listener);
            }
        }

        return b;
    }
}
