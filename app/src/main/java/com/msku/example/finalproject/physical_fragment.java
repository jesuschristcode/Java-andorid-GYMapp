package com.msku.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class physical_fragment extends Fragment {

    TextView sex ,age,fatrate,arm,chest,waist,height, weight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_physical_fragment,container,false);

        sex = view.findViewById(R.id.sexx);
        age = view.findViewById(R.id.Age);
        fatrate = view.findViewById(R.id.Ftrate);
        arm = view.findViewById(R.id.Armcrc);
        chest = view.findViewById(R.id.Chstcrc);
        waist = view.findViewById(R.id.Waistcrc);
        height = view.findViewById(R.id.Height);
        weight = view.findViewById(R.id.Weight);


        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager = new User_Manager(FirebaseAuth.getInstance());


        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("user")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        UserInfo user = documentSnapshot.toObject(UserInfo.class);
                        sex.setText(user.getSex());
                        arm.setText(String.valueOf(user.getArm()));
                        fatrate.setText(user.getFatRate());
                        chest.setText(String.valueOf(user.getChest()));
                        waist.setText(String.valueOf(user.getWaist()));
                        age.setText(String.valueOf(user.getAge()));
                        weight.setText(String.valueOf(user.getWeight()));
                        height.setText(String.valueOf(user.getHeight()));


                    } else {

                    }
                })
                .addOnFailureListener(e -> {

                });


        // Inflate the layout for this fragment
        return view;
    }
}