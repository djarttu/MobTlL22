package com.example.lab22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Stock> {
    ArrayList<Stock> arrayList = new ArrayList<>();
    private int k;

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Stock> objects) {
        super(context, textViewResourceId, objects);
        arrayList = objects;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_view_items, null);
       TextView text = v.findViewById(R.id.nameField);
       text.setText(arrayList.get(position).getStockName());
       TextView text2 = v.findViewById(R.id.priceField);
       text2.setText(arrayList.get(position).getStockPrice());
    return v;
    }
}