package com.example.mygpa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Model> item=new ArrayList<Model>();
    Context context;

    public MyAdapter(ArrayList<Model> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.row,null);
        TextView grade,hour;
        Button btn=view.findViewById(R.id.closeRow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.removeList(position);

            }
        });
        grade=view.findViewById(R.id.tGrade);
        hour=view.findViewById(R.id.tHour);
        Model model=item.get(position);
        grade.setText(model.getGrade()+"");
        hour.setText(model.getHour()+"");


        return view;
    }
}
