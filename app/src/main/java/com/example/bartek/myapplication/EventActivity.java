package com.example.bartek.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    private TextView tv1;
    private BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        tv1 = (TextView)findViewById(R.id.tv1);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
    }


    private void selectFragment(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_cal:
                Intent intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_bus:
                Intent intent1 = new Intent(this, BusActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_events:
                Intent intent2 = new Intent(this, EventActivity.class);
                startActivity(intent2);
                break;

        }
    }
}
