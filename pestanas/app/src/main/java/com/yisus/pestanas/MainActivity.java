package com.yisus.pestanas;

import android.os.Bundle;

import android.os.*;
import android.app.*;
import android.content.res.*;
import android.view.*;
import android.widget.*;
import android.widget.TabHost.*;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;
import com.yisus.pestanas.tabs.*;


public class MainActivity extends FragmentActivity {
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Pestaña 1"), Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Pestaña 2"), Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Pestaña 3"), Tab3.class, null);
    }
}