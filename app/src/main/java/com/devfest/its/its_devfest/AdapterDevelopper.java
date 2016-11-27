package com.devfest.its.its_devfest;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jihed on 27/11/2016.
 */

public class AdapterDevelopper extends ArrayAdapter<Developper> {
    Context context;
    int resource;
    public AdapterDevelopper(Context context, int resource, List<Developper> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);
        TextView nom = (TextView) view.findViewById(R.id.textView2);
        TextView prenom = (TextView) view.findViewById(R.id.textView3);
        TextView email = (TextView) view.findViewById(R.id.textView4);
        TextView tel = (TextView) view.findViewById(R.id.textView5);
        ImageView img = (ImageView) view.findViewById(R.id.imageView2);
        nom.setText(getItem(position).getNom());
        prenom.setText(getItem(position).getPrenom());
        email.setText(getItem(position).getEmail());
        tel.setText(getItem(position).getTel());
        img.setBackgroundResource(getItem(position).getImage());

        return view;
    }
}
