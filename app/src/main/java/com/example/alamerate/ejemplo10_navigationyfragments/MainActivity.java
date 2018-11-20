package com.example.alamerate.ejemplo10_navigationyfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.alamerate.ejemplo10_navigationyfragments.fragments.CameraFragment;
import com.example.alamerate.ejemplo10_navigationyfragments.fragments.GalleryFragment;
import com.example.alamerate.ejemplo10_navigationyfragments.fragments.ManageFragment;
import com.example.alamerate.ejemplo10_navigationyfragments.fragments.SlideShowFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        contenedor= findViewById(R.id.contenedor);
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

            //PASO 1 INSTANCIAR EL NUEVO FRAGMENT
            CameraFragment cameraFragment = new CameraFragment();
            //PASO 2 Colocar el nuevo fragment en visible
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedor, cameraFragment).commit();
        } else if (id == R.id.nav_gallery) {

            //PASO 1 INSTANCIAR EL NUEVO FRAGMENT
            GalleryFragment galleryFragment = new GalleryFragment();
            //PASO 2 Colocar el nuevo fragment en visible
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.contenedor, galleryFragment).commit();

        } else if (id == R.id.nav_slideshow) {

            //PASO 1 INSTANCIAR EL NUEVO FRAGMENT
            SlideShowFragment slideShowFragment = new SlideShowFragment();
            //PASO 2 Colocar el nuevo fragment en visible
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.contenedor,slideShowFragment).commit();

        } else if (id == R.id.nav_manage) {

            //PASO 1 INSTANCIAR EL NUEVO FRAGMENT
            ManageFragment manageFragment = new ManageFragment();
            //PASO 2 Colocar el nuevo fragment en visible
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.contenedor, manageFragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
