package com.example.roman.mycompanyapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by roman on 11.02.2018.
 */

class EmployeeAdapter extends ArrayAdapter<Employee> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Employee> employeeList;

    EmployeeAdapter(Context context, int resource, ArrayList<Employee> employees) {
        super(context, resource, employees);
        this.employeeList = employees;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Employee employee = employeeList.get(position);
        viewHolder.nameView.setText(employee.getName());
        viewHolder.positionView.setText(employee.getPosition());
        viewHolder.cityView.setText(employee.getCity());
        viewHolder.photoImage.setImageResource(employee.getPhoto());
        viewHolder.followersView.setText(employee.getFollowers()+" Followers");

        viewHolder.addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employee.setFollowers(employee.getFollowers()+1);
                viewHolder.followersView.setText(employee.getFollowers()+" Followers");
            }
        });


        return convertView;
    }

    private String formatValue(int count, String unit){
        return String.valueOf(count) + " " + unit;
    }
    private class ViewHolder {
        final ImageView photoImage;
        final TextView nameView, positionView, followersView, cityView, addView;

        ViewHolder(View view){
            photoImage = view.findViewById(R.id.imgViewPhoto);
            nameView = (TextView) view.findViewById(R.id.tvNameSurname);
            positionView = (TextView) view.findViewById(R.id.tvPosition);
            followersView = (TextView) view.findViewById(R.id.tvFollowers);
            cityView = (TextView) view.findViewById(R.id.tvCity);
            addView = (TextView) view.findViewById(R.id.tvAdd);
        }
    }
}
