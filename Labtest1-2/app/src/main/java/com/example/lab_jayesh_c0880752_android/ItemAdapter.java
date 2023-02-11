package com.example.lab_jayesh_c0880752_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<String> {
    private final Context context;
    private ArrayList<String> items;

    public ItemAdapter(Context context, ArrayList<String> items) {
        super(context,R.layout.list_item, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.text_view);
        textView.setText(items.get(position));

        return rowView;
    }
}



