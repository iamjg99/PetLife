package com.example.pl1.Adoptview;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.pl1.Adoptview.petdisplay.petdisplay;
import com.example.pl1.Adoptview.utils.CommonUtils;
import com.example.pl1.Adoptview.utils.DividerItemDecoration;
import com.example.pl1.MainActivity;
import com.example.pl1.R;
import com.example.pl1.Submit;
import com.example.pl1.donate;
import com.example.pl1.profile;
import com.example.pl1.ratingview;
import com.example.pl1.settings;
import com.example.pl1.userswitch;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class adoptview extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,PetAdapter.Callback {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    PetAdapter mSportAdapter;
    LinearLayoutManager mLayoutManager;
    Button adoptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        final AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        adoptr=(Button)findViewById(R.id.adoptbtn);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        ButterKnife.bind(this);
        setUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.adoptview, menu);
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

        if (id == R.id.nav_editprof) {
            // Handle the camera action
            Intent intentprof = new Intent(this, profile.class);
            startActivity(intentprof);
        } else if (id == R.id.nav_switchusers) {
            Intent intent10 = new Intent(this, userswitch.class);
            startActivity(intent10);
        } else if (id == R.id.nav_settings) {
            Intent intentset = new Intent(this, settings.class);
            startActivity(intentset);
        } else if (id == R.id.nav_rate) {
            Intent intentrat = new Intent(this, ratingview.class);
            startActivity(intentrat);
        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_exit) {
            finish();
        } else if (id == R.id.nav_share) {
            shareTextUrl();
        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, "Please give this application a try");

        startActivity(Intent.createChooser(share, "Share link!"));
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mSportAdapter = new PetAdapter(new ArrayList<>());
        prepareDemoContent();
    }

    private void prepareDemoContent() {
        CommonUtils.showLoading(adoptview.this);
        new Handler().postDelayed(() -> {
            //prepare data and show loading
            CommonUtils.hideLoading();
            ArrayList<Pet> mSports = new ArrayList<>();
            String[] petList = getResources().getStringArray(R.array.pet_Category);
            String[] petInfo = getResources().getStringArray(R.array.pet_info);
            String[] petImage = getResources().getStringArray(R.array.pet_images);
            for (int i = 0; i < petList.length; i++) {
                mSports.add(new Pet(petImage[i], petInfo[i], "Feed",petList[i]));
            }
            mSportAdapter.addItems(mSports);
            mRecyclerView.setAdapter(mSportAdapter);
        }, 2000);


    }

    @Override
    public void onEmptyViewRetryClick() {
        prepareDemoContent();
    }
}


