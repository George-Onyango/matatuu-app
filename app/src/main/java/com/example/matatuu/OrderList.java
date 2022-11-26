package com.example.matatuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Order> orderArrayList;
    myAdapter MyAdapter;
    DatabaseReference nDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        recyclerView = findViewById(R.id.rvOrderList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        nDatabase = FirebaseDatabase.getInstance().getReference("orders");
        orderArrayList = new ArrayList<Order>();
        MyAdapter = new myAdapter(OrderList.this,orderArrayList);
        recyclerView.setAdapter(MyAdapter);

       nDatabase.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                   Order order = dataSnapshot.getValue(Order.class);
                   orderArrayList.add(order);
               }
               MyAdapter.notifyDataSetChanged();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

    }


}