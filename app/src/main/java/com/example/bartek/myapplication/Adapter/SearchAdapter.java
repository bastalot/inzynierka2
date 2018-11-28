package com.example.bartek.myapplication.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bartek.myapplication.Model.Przystanek;
import com.example.bartek.myapplication.R;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView nazwa_przystanku;

    public SearchViewHolder(View itemView) {
        super(itemView);
        nazwa_przystanku = (TextView)itemView.findViewById(R.id.nazwa_przystanku);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Przystanek> przystanek;

    public SearchAdapter(Context context, List<Przystanek> przystanek) {
        this.context = context;
        this.przystanek = przystanek;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.nazwa_przystanku.setText(przystanek.get(position).getNazwa_przystanku());
    }

    @Override
    public int getItemCount() {
        return przystanek.size();
    }
}
