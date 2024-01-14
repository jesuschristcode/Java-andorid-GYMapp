package com.msku.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class program_fragment extends Fragment {

    TextView monday,tuesday,wednesday,thursday,friday,saturday,sunday;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_program_fragment, container, false);
        monday = view.findViewById(R.id.mndy);
        tuesday = view.findViewById(R.id.tuesday);
        wednesday = view.findViewById(R.id.wdnsday);
        thursday = view.findViewById(R.id.Thrsday);
        friday = view.findViewById(R.id.Frday);
        saturday = view.findViewById(R.id.Strday);
        sunday = view.findViewById(R.id.Snday);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager =  new User_Manager(FirebaseAuth.getInstance());



        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("userProgram")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        ProgramFitness programFitness = documentSnapshot.toObject(ProgramFitness.class);
                        monday.setText(programFitness.getMonday().replace(",", "\n"));
                        tuesday.setText(programFitness.getTuesday().replace(",", "\n"));
                        wednesday.setText(programFitness.getWednesday().replace(",", "\n"));
                        thursday.setText(programFitness.getThursday().replace(",", "\n"));
                        friday.setText(programFitness.getFriday().replace(",", "\n"));
                        saturday.setText(programFitness.getSaturday().replace(",", "\n"));
                        sunday.setText(programFitness.getSunday().replace(",", "\n"));

                    } else {
                        System.out.println("Document Does not exist");

                    }
                })
                .addOnFailureListener(e -> {

                });

        // Inflate the layout for this fragment
        return view;
    }
}