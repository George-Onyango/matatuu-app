package com.example.matatuu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    Context context;
    ArrayList<Order> orderArrayList;


    public myAdapter(Context context, ArrayList<Order> orderArrayList) {
        this.context = context;
        this.orderArrayList = orderArrayList;
    }

    @NonNull
    @Override
    public myAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.MyViewHolder holder, int position) {

        Order order = orderArrayList.get(position);

        holder.from.setText(order.getFrom());
        holder.to.setText(order.getTo());
        holder.dept.setText(order.getDeparture());
        holder.payment.setText(order.getPayment());

    }

    @Override
    public int getItemCount() {
        return orderArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView from, to, dept, payment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            from = itemView.findViewById(R.id.tvFrom);
            to = itemView.findViewById(R.id.tvTo);
            dept = itemView.findViewById(R.id.tvDep);
            payment = itemView.findViewById(R.id.tvPayment);
        }
    }
}
