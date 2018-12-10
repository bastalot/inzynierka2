package com.example.bartek.myapplication.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bartek.myapplication.BusStop;
import com.example.bartek.myapplication.Database.Database;
import com.example.bartek.myapplication.Model.Bus;
import com.example.bartek.myapplication.Model.Przystanek;
import com.example.bartek.myapplication.R;

import java.util.List;

class BusViewHolder extends RecyclerView.ViewHolder{

    public View view;
    public TextView idlinia_autobusowa, przystanek_poczatkowy, przystanek_koncowy;


    public BusViewHolder(View itemView) {
        super(itemView);
        idlinia_autobusowa = (TextView)itemView.findViewById(R.id.idlinia_autobusowa);
        przystanek_poczatkowy = (TextView)itemView.findViewById(R.id.przystanek_poczatkowy);
        przystanek_koncowy = (TextView)itemView.findViewById(R.id.przystanek_koncowy);

    }
}

public class BusAdapter extends RecyclerView.Adapter<BusViewHolder>{

    private List<Bus> bus;
    private Context context;


    public BusAdapter(List<Bus> bus, Context context) {
        this.bus = bus;
        this.context = context;
    }

    @Override
    public BusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_busitem,parent,false);
        return new BusViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BusViewHolder holder, int position) {
        holder.idlinia_autobusowa.setText(Integer.toString(bus.get(position).getIdlinia_autobusowa()));
        //holder.przystanek_poczatkowy.setText(db.getPrzystanekById(Integer.valueOf(bus.get(position).getPrzystanek_poczatkowy()), "przystanek_poczatkowy"));
        //holder.przystanek_koncowy.setText(db.getPrzystanekById(Integer.valueOf(bus.get(position).getPrzystanek_koncowy()), "przystanek_koncowy"));
        //holder.przystanek_poczatkowy.setText(Integer.toString(bus.get(position).getPrzystanek_poczatkowy()));
        //holder.przystanek_koncowy.setText(Integer.toString(bus.get(position).getPrzystanek_koncowy()));
        holder.przystanek_poczatkowy.setText(bus.get(position).getPrzystanek_poczatkowy());
        holder.przystanek_koncowy.setText(bus.get(position).getPrzystanek_koncowy());
    }

    @Override
    public int getItemCount() {
        return bus.size();
    }
}
