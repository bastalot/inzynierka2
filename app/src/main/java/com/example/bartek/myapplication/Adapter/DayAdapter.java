package com.example.bartek.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bartek.myapplication.Model.Notatka;
import com.example.bartek.myapplication.Model.Wydarzenie;
import com.example.bartek.myapplication.R;

import java.util.List;

class DayViewHolder extends RecyclerView.ViewHolder {

    public View view;
    public TextView data_note, text;

    public DayViewHolder(View itemView){
        super(itemView);
        data_note = (TextView)itemView.findViewById(R.id.data_note);
        text = (TextView)itemView.findViewById(R.id.note);
    }
}

public class DayAdapter extends  RecyclerView.Adapter<DayViewHolder>{

    private List<Notatka> text;
    private Context context;

    public DayAdapter(List<Notatka> text, Context context) {
        this.text = text;
        this.context = context;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_day_item, parent, false);
        return new DayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {

        holder.data_note.setText(text.get(position).getData());
        holder.text.setText(text.get(position).getText());
    }



    @Override
    public int getItemCount() {
        return text.size();
    }





}

