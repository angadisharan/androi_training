package com.mathrusoft.teacher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mathrusoft.teacher.database.DataSource;
import com.mathrusoft.teacher.fragments.FragmentAttendance;
import com.mathrusoft.teacher.fragments.FragmentGallery;
import com.mathrusoft.teacher.fragments.FragmentSaveStudent;
import com.mathrusoft.teacher.fragments.FragmentSettings;
import com.mathrusoft.teacher.model.Student;
import com.mathrusoft.teacher.utils.Constants;

public class ActivityMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "ActivityMain";
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d(TAG, "Inside onOptionsItemSelected ");

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(mContext, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:

//                getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE).edit().clear();
                SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit().clear();
                editor.clear();
                editor.commit();

                Intent intent = new Intent(mContext, ActivityLogin.class);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_gallery) {
            attachFragment(new FragmentGallery());

//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(R.id.fragment_holder, new FragmentGallery());
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_attendance) {
            attachFragment(new FragmentAttendance());
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(R.id.fragment_holder, new FragmentAttendance());
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_settings) {
            attachFragment(new FragmentSettings());

//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(R.id.fragment_holder, new FragmentSettings());
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_share) {
            Toast.makeText(mContext, " nav_share click", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(mContext, " nav_send click", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_save_student) {
            attachFragment(new FragmentSaveStudent());
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    Fragment mAttachedFragment;

    private void attachFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (mAttachedFragment != null) {
            fragmentTransaction.remove(mAttachedFragment);
        }

        fragmentTransaction.add(R.id.fragment_holder, fragment);
        fragmentTransaction.commit();

        mAttachedFragment = fragment;
    }
}
