package com.msku.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class Fitness_program extends AppCompatActivity  {
    TextView monday,tuesday,wednesday,thursday,friday,saturday,sunday;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_program);
        monday = findViewById(R.id.mndy);
        tuesday = findViewById(R.id.tuesday);
        wednesday = findViewById(R.id.wdnsday);
        thursday = findViewById(R.id.Thrsday);
        friday = findViewById(R.id.Frday);
        saturday = findViewById(R.id.Strday);
        sunday = findViewById(R.id.Snday);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager =  new User_Manager(FirebaseAuth.getInstance());


        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("userProgram")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        ProgramFitness programFitness = documentSnapshot.toObject(ProgramFitness.class);
                        monday.setText(programFitness.getMonday());
                        tuesday.setText(programFitness.getTuesday());
                        wednesday.setText(programFitness.getWednesday());
                        thursday.setText(programFitness.getThursday());
                        friday.setText(programFitness.getFriday());
                        saturday.setText(programFitness.getSaturday());
                        sunday.setText(programFitness.getSunday());

                    } else {
                        System.out.println("Document Does not exist");

                    }
                })
                .addOnFailureListener(e -> {

                });
    }

}