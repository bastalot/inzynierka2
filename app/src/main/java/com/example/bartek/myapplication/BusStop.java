package com.example.bartek.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.bartek.myapplication.Adapter.BusAdapter;
import com.example.bartek.myapplication.Database.Database;

import java.util.ArrayList;
import java.util.List;

public class BusStop extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    BusAdapter adapter;

    List<String> suggestList = new ArrayList<>();


    Database database;
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busstop);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_bus);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        database = new Database(this);

        //loadSuggestList();

        adapter = new BusAdapter(database.getBus(), this);
        recyclerView.setAdapter(adapter);


    }

    /*
    private void loadSuggestList(){
        suggestList = database.getBusNumbers();

    }*/

}
