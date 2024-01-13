package com.msku.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class nutritition_fragment extends Fragment {

    TextView sunday,monday,tuesday,wednesday,thursday,friday,saturday;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  =  inflater.inflate(R.layout.fragment_nutritition_fragment,container,false);
        sunday = view.findViewById(R.id.pazar);
        monday = view.findViewById(R.id.pzt);
        tuesday = view.findViewById(R.id.salı);
        wednesday = view.findViewById(R.id.çarşamba);
        thursday = view.findViewById(R.id.perşembe);
        friday = view.findViewById(R.id.cuma);
        saturday =view.findViewById(R.id.cumartesi);




        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager =  new User_Manager(FirebaseAuth.getInstance());


        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("userNutritition")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        UserNutritition userNutritition = documentSnapshot.toObject(UserNutritition.class);
                        monday.setText(userNutritition.getMonday());
                        sunday.setText(userNutritition.getSunday());
                        tuesday.setText(userNutritition.getTuesday());
                        saturday.setText(userNutritition.getSaturday());
                        friday.setText(userNutritition.getFriday());
                        thursday.setText(userNutritition.getThursday());
                        wednesday.setText(userNutritition.getWednesday());





                    } else {

                    }
                })
                .addOnFailureListener(e -> {

                });
        // Inflate the layout for this fragment
        return view;
    }
}