package com.example.php_mysql_crud_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Employee> {

    Context context;
    List<Employee> employeesList;

    public MyAdapter(Context context, List<Employee> employeesList) {
        super(context,R.layout.custom_list_item,employeesList);

        this.context = context;
        this.employeesList = employeesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(employeesList.get(position).getId());
        tvName.setText(employeesList.get(position).getName());

        return view;
    }
}
