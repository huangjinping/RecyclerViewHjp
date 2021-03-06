package com.de.hjp.recyclerview;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.de.hjp.recyclerview.collection.CollectionActivity;
import com.de.hjp.recyclerview.dagger2.Dagger2Activity;
import com.de.hjp.recyclerview.eventbus.EventBusFirstActivity;
import com.de.hjp.recyclerview.glide.GlideActivity;
import com.de.hjp.recyclerview.index.IndexAdapter;
import com.de.hjp.recyclerview.index.Item;
import com.de.hjp.recyclerview.jsjava.JavaActivity;
import com.de.hjp.recyclerview.jsjava.JsBridgeActivity;
import com.de.hjp.recyclerview.jsjava.WebActivity;
import com.de.hjp.recyclerview.listview.ListActivity;
import com.de.hjp.recyclerview.retrofit.RetrofitActivity;
import com.de.hjp.recyclerview.rxjava.RxJavaActivity;
import com.de.hjp.recyclerview.timer.TimedTask;
import com.de.hjp.recyclerview.view.CostomViewActivity;
import com.de.hjp.recyclerview.xListview.XListViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView rec_index;
    private IndexAdapter indexAdapter;
    private List<Item> dataList = new ArrayList<>();
    private Class[] CLAZZES = new Class[]
            {
                    EventBusFirstActivity.class,
                    CollectionActivity.class,
                    RxJavaActivity.class,
                    IndexActivity.class,
                    JavaActivity.class,
                    XListViewActivity.class,
                    GlideActivity.class,
                    CostomViewActivity.class,
                    WebActivity.class,
                    Dagger2Activity.class,
                    WindowManagerActivity.class,
                    RetrofitActivity.class,
                    JsBridgeActivity.class,
                    ContactsActivity.class,
                    ListActivity.class
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        System.out.println("=====>task111>>>>>");

        TimedTask timedTask = TimedTask.getTimedTask();
        timedTask.setRecLen(1000);
        timedTask.requestListener(new TimedTask.TimedTaskListener() {

            @Override
            public void onTimedTask(int recLen) {
//                Log.d("ddd", "=====>>>>>>" + recLen);
//                System.out.println("=====>task111>>>>>6");
//                System.out.println("=====>>>>>>" + recLen);
            }
        });
        timedTask.start();
        initLog();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        rec_index = (RecyclerView) findViewById(R.id.rec_index);

        rec_index.setLayoutManager(new LinearLayoutManager(this));
        indexAdapter = new IndexAdapter(CLAZZES);
        rec_index.setAdapter(indexAdapter);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initLog() {
//      final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
//      final String logPath = SDCARD + "/marssample/log";

//init xlog
//      if (BuildConfig.DEBUG) {
//          Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, "", logPath, "MarsSample");
//          Xlog.setConsoleLogOpen(true);
//
//      } else {
//          Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, "", logPath, "MarsSample");
//          Xlog.setConsoleLogOpen(false);
//      }
//      Log.setLogImp(new Xlog());
    }


    static {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("marsxlog");
    }
}
