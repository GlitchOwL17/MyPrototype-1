package com.example.myprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuGridItem> {
    private Context mContext;
    int mResource;
    public MenuAdapter(@NonNull Context context, int resource, ArrayList<MenuGridItem> itemList) {
        super(context, resource, itemList);
        mContext = context;
        mResource = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        int img = getItem(position).getMenuImage();
        String name = getItem(position).getMenuTitle();

        MenuGridItem Team = new  MenuGridItem(name,img);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView menuImg =(ImageView)convertView.findViewById(R.id.layout_img);
        TextView menuTitle = (TextView)convertView.findViewById(R.id.layout_Name);


        menuImg.setImageResource(img);
        menuTitle.setText(name);
        return convertView;

    }
}
