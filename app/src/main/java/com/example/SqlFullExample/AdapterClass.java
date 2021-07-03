package com.example.SqlFullExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterClass extends ArrayAdapter<DataClass> {
    public AdapterClass(@NonNull Context context,int resource, @NonNull ArrayList<DataClass> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout, parent, false);
        }

        DataClass currentview =  getItem(position);

        TextView wordtext = (TextView) convertView.findViewById(R.id.wordText);
        wordtext.setText(currentview.getWord());

        TextView explainingtext = (TextView) convertView.findViewById(R.id.explaningText);
        explainingtext.setText(currentview.getExplaining());





        return convertView;
    }
}
