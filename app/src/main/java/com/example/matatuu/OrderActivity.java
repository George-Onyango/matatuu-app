package com.example.matatuu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matatuu.databinding.ActivityOrderBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    FirebaseDatabase db;
     DatabaseReference mDatabase;
     String edFromLocation,edToLocation,edDeparture,edPayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnForm.setOnClickListener(view -> {
            edFromLocation = binding.edFromLocation.getText().toString();
                    edToLocation = binding.edToLocation.getText().toString();
                    edDeparture = binding.edDeparture.getText().toString();
                    edPayment = binding.edPayment.getText().toString();


                    if (edDeparture.isEmpty() && edToLocation.isEmpty() && edFromLocation.isEmpty() && edPayment.isEmpty()){
                        Order order = new Order(edFromLocation,edToLocation,edDeparture,edPayment);
                        User user = new User();
                        db = FirebaseDatabase.getInstance();
                        mDatabase = db.getReference("orders");
                        mDatabase.child(user.firstName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                binding.edToLocation.setText("");
                                binding.edFromLocation.setText("");
                                binding.edDeparture.setText("");
                                binding.edPayment.setText("");

                                Toast.makeText(OrderActivity.this, "Successfully Ordered", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
        });


    }




}