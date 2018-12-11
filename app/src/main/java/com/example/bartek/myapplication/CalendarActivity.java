package com.example.bartek.myapplication;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class CalendarActivity extends AppCompatActivity {

    //private TextView tv_bus;
    //private TextView tv_events;

    private BottomNavigationView mBottomNav;
    //private int mSelectedItem;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        HashSet<Date> events = new HashSet<>();
        events.add(new Date());

        CalendarView cv = ((CalendarView)findViewById(R.id.calendar_view));
        cv.updateCalendar(events);

        //tv_events = (TextView)findViewById(R.id.event_menu);
        //tv_bus = (TextView)findViewById(R.id.bus_menu);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        // assign event handler
        cv.setEventHandler(new CalendarView.EventHandler()
        {
            @Override
            public void onDayLongPress(Date date)
            {
                // show returned day
                DateFormat df = SimpleDateFormat.getDateInstance();
                Toast.makeText(CalendarActivity.this,  df.format(date), Toast.LENGTH_SHORT).show();
            }
        });

        /*tv_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentBus = new Intent(CalendarActivity.this, BusActivity.class);
                startActivity(intentBus);



            }
        });*/

    }

    private void selectFragment(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_cal:
                //Intent intent = new Intent(this, CalendarActivity.class);
                //startActivity(intent);
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
