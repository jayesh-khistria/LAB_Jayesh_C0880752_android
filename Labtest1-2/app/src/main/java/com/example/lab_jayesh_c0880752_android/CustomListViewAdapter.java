package com.example.lab_jayesh_c0880752_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListViewAdapter extends BaseAdapter {

    private String cityName;
    private Context mContext;

    public CustomListViewAdapter(Context context, String cityName) {
        this.mContext = context;
        this.cityName = cityName;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return cityName;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }
        TextView cityNameTextView = convertView.findViewById(R.id.text_view);
        cityNameTextView.setText(cityName);
        return convertView;
    }
}
